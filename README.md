# 🎓 ISO2-2026-Grupo3C1.02-Testing-P2 — Gestión de Becas Universitarias

🧪 **Segundo Ejercicio Teórico y Segunda Parte de Prácticas (ET.02)** · 🎓 **Ingeniería del Software II (Curso 2026/27)** · 👥 **Equipo 3C1.02 (ESI · UCLM)**

Repositorio independiente correspondiente al **Problema 2 (ET.02.03)** dentro del proyecto colaborativo de pruebas del [Equipo 3C1.02](https://github.com/ruben-ab99/ISO26-ISO2-3C1.02) ([Wiki · Parte Testing](https://github.com/ruben-ab99/ISO26-ISO2-3C1.02/wiki/Parte-Testing)).

---

## 👥 Reparto de Responsabilidades (Tabla 1)

| Etapa | Actividad | Rama / Entregable | Pareja Responsable |
| :--- | :--- | :--- | :--- |
| **Paso 1** | Implementación del programa en Java + Maven (SOLID) | Rama `develop` | **Pareja 2:** Raúl Martínez y Silviu-Daniel Zamfir |
| **Paso 2** | Diseño de casos de prueba (clases equiv., límites, PICT, MC/DC) | `ISO2-2026-Grupo3C1.02-Testing-P2.pdf` + Wiki | **Pareja 3** Sin Asignar |
| **Paso 3** | Implementación de pruebas JUnit 5 y cobertura JaCoCo ($\ge 80\%$) | Rama `hotfix` + Informes en Wiki | **Pareja 1** Sin Asignar |

---

## 📋 Reglas de Negocio y Suposiciones de Diseño

El sistema evalúa los datos académicos y socioeconómicos de un estudiante universitario (`notaMedia`, `rentaFamiliar`, `distanciaKm`, `gradoDiscapacidad`, `numeroHermanos`) para determinar la modalidad de beca aplicable:

* **Beca de Excelencia:** `notaMedia >= 8.5` y `rentaFamiliar < 30.000 €` *(exención total de tasas + dotación de 1.000 €)*.
* **Beca de Residencia:** `6.5 <= notaMedia <= 8.4`, `rentaFamiliar < 20.000 €` y `distanciaKm > 50 km` *(exención total + ayuda de alojamiento)*.
* **Beca de Familia Numerosa:** `notaMedia >= 5.0`, `rentaFamiliar < 15.000 €` y `numeroHermanos >= 3` *(exención total de tasas)*.
* **Beca de Inclusión:** `gradoDiscapacidad >= 33%` y `notaMedia >= 5.0` *(exención total + dotación de apoyo tecnológico)*.

### Decisiones ante ambigüedades y validación (`es tu diseño, es tu decisión`)
1. **Control de ambigüedades (`BecaAmbiguaException`):** Dado que un mismo estudiante puede cumplir simultáneamente los criterios de varias modalidades (por ejemplo, Excelencia e Inclusión), el sistema evalúa todas las candidatas y lanza `BecaAmbiguaException` listando las becas compatibles si hay más de una.
2. **Ausencia de beca (`TipoBeca.SIN_BECA`):** Si el estudiante tiene datos válidos pero no alcanza los requisitos de ninguna modalidad, se devuelve `TipoBeca.SIN_BECA`.
3. **Encapsulamiento y validación de dominio (`IllegalArgumentException`):** El constructor de `Estudiante` valida que los parámetros estén en rangos coherentes (`notaMedia` en $[0, 10]$, `gradoDiscapacidad` en $[0, 100]$, y `rentaFamiliar`, `distanciaKm` y `numeroHermanos` $\ge 0$). `GestorBecasImpl` rechaza entradas `null`.

---

## 🏗️ Estructura del Proyecto Maven

```text
ISO2-2026-Grupo3C1.02-Testing-P2/
├── pom.xml                                      # Java 21, JUnit 5, Surefire y JaCoCo
└── src/
    ├── main/java/es/uclm/esi/iso2/becas/
    │   ├── TipoBeca.java                        # Enumerado con modalidades y descripciones
    │   ├── Estudiante.java                      # Entidad inmutable con validación en constructor
    │   ├── BecaAmbiguaException.java            # Excepción controlada para solapamientos
    │   ├── IGestorBecas.java                    # Contrato de servicio (desacoplamiento SOLID)
    │   ├── GestorBecasImpl.java                 # Lógica de negocio de evaluación de becas
    │   └── Main.java                            # Interfaz CLI desacoplada del dominio
    └── test/java/es/uclm/esi/iso2/becas/        # Pruebas unitarias JUnit 5 (Paso 3 - rama hotfix)
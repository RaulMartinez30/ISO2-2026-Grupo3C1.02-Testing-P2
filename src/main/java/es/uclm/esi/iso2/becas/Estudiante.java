package es.uclm.esi.iso2.becas;

public class Estudiante {
    private final double notaMedia;
    private final double rentaFamiliar;
    private final double distanciaKm;
    private final double gradoDiscapacidad;
    private final int numeroHermanos;

    public Estudiante(double notaMedia, double rentaFamiliar, double distanciaKm,
                      double gradoDiscapacidad, int numeroHermanos) {
        if (notaMedia < 0.0 || notaMedia > 10.0) {
            throw new IllegalArgumentException("La nota media debe estar entre 0,0 y 10,0.");
        }
        if (rentaFamiliar < 0.0) {
            throw new IllegalArgumentException("La renta familiar no puede ser negativa.");
        }
        if (distanciaKm < 0.0) {
            throw new IllegalArgumentException("La distancia al campus no puede ser negativa.");
        }
        if (gradoDiscapacidad < 0.0 || gradoDiscapacidad > 100.0) {
            throw new IllegalArgumentException("El grado de discapacidad debe estar entre 0% y 100%.");
        }
        if (numeroHermanos < 0) {
            throw new IllegalArgumentException("El número de hermanos no puede ser negativo.");
        }

        this.notaMedia = notaMedia;
        this.rentaFamiliar = rentaFamiliar;
        this.distanciaKm = distanciaKm;
        this.gradoDiscapacidad = gradoDiscapacidad;
        this.numeroHermanos = numeroHermanos;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public double getRentaFamiliar() {
        return rentaFamiliar;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public double getGradoDiscapacidad() {
        return gradoDiscapacidad;
    }

    public int getNumeroHermanos() {
        return numeroHermanos;
    }
}
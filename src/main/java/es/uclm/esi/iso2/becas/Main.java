package es.uclm.esi.iso2.becas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IGestorBecas gestor = new GestorBecasImpl();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nota media (0-10): ");
            double nota = sc.nextDouble();
            System.out.print("Renta familiar (€): ");
            double renta = sc.nextDouble();
            System.out.print("Distancia al campus (km): ");
            double distancia = sc.nextDouble();
            System.out.print("Grado de discapacidad (%): ");
            double discapacidad = sc.nextDouble();
            System.out.print("Número de hermanos: ");
            int hermanos = sc.nextInt();

            Estudiante estudiante = new Estudiante(nota, renta, distancia, discapacidad, hermanos);
            TipoBeca resultado = gestor.determinarBeca(estudiante);
            System.out.println("Resultado: " + resultado.getDescripcion());
        } catch (IllegalArgumentException | BecaAmbiguaException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
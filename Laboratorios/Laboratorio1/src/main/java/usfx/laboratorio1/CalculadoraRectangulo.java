package usfx.laboratorio1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author micky
 */
import java.util.Scanner;

public class CalculadoraRectangulo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float longitud=0;
        float ancho=0;

        while (true) {
            System.out.println("=== Menu de Rectangulo ===");
            System.out.println("1. Ingresar dimensiones");
            System.out.println("2. Calcular area");
            System.out.println("3. Calcular perimetro");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la longitud del rectangulo: ");
                    longitud = scanner.nextFloat();
                    System.out.print("Ingrese el ancho del rectángulo: ");
                    ancho = scanner.nextFloat();
                    break;
                case 2:
                    if (longitud > 0 && ancho > 0) {
                        float area = calcularArea(longitud, ancho);
                        System.out.println("El área del rectangulo es: " + area);
                    } else {
                        System.out.println("Por favor, ingrese primero las dimensiones del rectangulo.");
                    }
                    break;
                case 3:
                    if (longitud > 0 && ancho > 0) {
                        float perimetro = calcularPerimetro(longitud, ancho);
                        System.out.println("El perímetro del rectangulo es: " + perimetro);
                    } else {
                        System.out.println("Por favor, ingrese primero las dimensiones del rectangulo.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 4.");
            }
        }
    }

    private static float calcularArea(float longitud, float ancho) {
        return longitud * ancho;
    }

    private static float calcularPerimetro(float longitud, float ancho) {
        return 2 * (longitud + ancho);
    }
}

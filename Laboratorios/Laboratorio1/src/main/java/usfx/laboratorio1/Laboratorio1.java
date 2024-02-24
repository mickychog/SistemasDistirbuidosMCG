/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package usfx.laboratorio1;

/**
 *
 * @author micky
 */

import java.util.Scanner;

public class Laboratorio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Menú de Ejercicios ===");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 3");
            System.out.println("3. Ejercicio 5");
            System.out.println("4. Ejercicio 7");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ejercicio1();
                    break;
                case 2:
                    ejercicio3();
                    break;
                case 3:
                    ejercicio5();
                    break;
                case 4:
                    ejercicio7();
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida. Por favor, ingrese un numero del 1 al 4.");
            }
        }
    }

    private static void ejercicio1() {
        System.out.println("Ejercicio 1 seleccionado.");
        System.out.println("--------------------------");
        // Llamada al método main de la CalculadoraRectangulo
        CalculadoraRectangulo.main(new String[]{});
    }

    private static void ejercicio3() {
        System.out.println("Ejercicio 3 seleccionado.");
        System.out.println("--------------------------");
        CajeroAutomatico.main(new String[]{});
    }

    private static void ejercicio5() {
        System.out.println("Ejercicio 5 seleccionado.");
        System.out.println("--------------------------");
        AgendaContactos.main(new String[]{});
        
    }
    
    private static void ejercicio7() {
        System.out.println("Ejercicio 7 seleccionado.");
        System.out.println("--------------------------");
        CalculadoraIMC.main(new String[]{});
    }
}
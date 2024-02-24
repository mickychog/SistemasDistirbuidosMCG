/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.laboratorio1;

/**
 *
 * @author micky
 */
import java.util.Scanner;

public class CajeroAutomatico {

    private static double saldo = 1000;
    private static  String USUARIO = "usuario";
    private static  String CONTRASENA = "12345";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!autenticarUsuario()) {
            System.out.println("Usuario o contrasena incorrectos. Saliendo del programa.");
            return;
        }
        while (true) {
            System.out.println("------------------------------");
            System.out.println("=== Menu Cajero Automatico ===");
            System.out.println("------------------------------");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    depositarDinero();
                    break;
                case 3:
                    retirarDinero();
                    break;
                case 4:
                    System.out.println("Saliendo del cajero automatico.");
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida. Por favor, ingrese un numero del 1 al 4.");
            }
        }
    }
    
    private static boolean autenticarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        return usuario.equals(USUARIO) && contrasena.equals(CONTRASENA);
    }
    
    private static void consultarSaldo() {
        System.out.println("Su saldo actual es: $" + saldo);
    }

    private static void depositarDinero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad a depositar: $");
        double cantidad = scanner.nextDouble();

        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Deposito exitoso. Su nuevo saldo es: $" + saldo);
        } else {
            System.out.println("Error: La cantidad a depositar debe ser mayor que cero.");
        }
    }

    private static void retirarDinero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad a retirar: $");
        double cantidad = scanner.nextDouble();

        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Su nuevo saldo es: $" + saldo);
        } else if (cantidad <= 0) {
            System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
        } else {
            System.out.println("Error: Fondos insuficientes. Su saldo actual es: $" + saldo);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.lab3_ejercicio3;

/**
 *
 * @author micky
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            IOperaciones operaciones = (IOperaciones) Naming.lookup("rmi://localhost/Operaciones");
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("****************************");
                System.out.println("Seleccione una opcion:");
                System.out.println("1. Introducir datos");
                System.out.println("2. Sumar");
                System.out.println("3. Restar");
                System.out.println("4. Salir");
                System.out.print("Opción: ");

                try {
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            int a, b;
                            do {
                                System.out.print("Ingrese el valor de a: ");
                                while (!scanner.hasNextInt()) {
                                    System.out.println("Error: Debe ingresar un numero entero.");
                                    scanner.next();
                                    System.out.print("Ingrese el valor de a: ");
                                }
                                a = scanner.nextInt();

                                System.out.print("Ingrese el valor de b: ");
                                while (!scanner.hasNextInt()) {
                                    System.out.println("Error: Debe ingresar un numero entero.");
                                    scanner.next(); 
                                    System.out.print("Ingrese el valor de b: ");
                                }
                                b = scanner.nextInt();

                                operaciones.anotar(a, b);
                                System.out.println("Datos anotados correctamente.");
                            } while (a == 0 || b == 0);
                            break;
                        case 2:
                            System.out.println("El resultado de la suma es: " + operaciones.suma());
                            break;
                        case 3:
                            System.out.println("El resultado de la resta es: " + operaciones.restar());
                            break;
                        case 4:
                            System.out.println("Saliendo...");
                            break;
                        default:
                            System.out.println("Opcion invalida. Inténtelo de nuevo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un número entero.");
                    scanner.nextLine(); 
                    opcion = 0; 
                }

            } while (opcion != 4);

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}

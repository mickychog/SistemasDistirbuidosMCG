/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reservahotel;

import java.util.Scanner;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;


public class ClienteReserva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {

        int op = 0;

        String inicio = "";
        String fin = "";
        String fechaCotizacion = "";
        String fechaCompra = "";
        String idcliente = "";

        Scanner sc = new Scanner(System.in);

        IServidorReserva sr;
        sr = (IServidorReserva) Naming.lookup("rmi://localhost/RESERVA_SERVIDOR");

        System.out.println("-------------------HOTEL-------------------");
        System.out.println("Bienvenido, que desea realizar?");
        System.out.println("1. Cotizar");
        System.out.println("2. Reserva");
        System.out.print("Ingrese las opciones que desea realizar: ");
        op = sc.nextInt();
        System.out.println("");
        sc.nextLine();
        switch (op) {

            case 1:
                System.out.print("Ingrese la fecha inicial:");
                inicio = sc.next();
                System.out.println("");
                System.out.print("Ingrese la fecha final:");
                fin = sc.next();
                System.out.println("");
                System.out.print("Ingrese la fecha actual:");
                fechaCotizacion = sc.next();
                System.out.println("");
                double cotizacion = sr.Cotizar(inicio, fin, fechaCotizacion);
                System.out.println("El precio final es: " + cotizacion + " Bs");
                break;

            case 2:
                System.out.print("Ingrese la fecha inicial:");
                inicio = sc.next();
                System.out.println("");
                System.out.print("Ingrese la fecha final:");
                fin = sc.next();
                System.out.println("");
                System.out.print("Ingrese el id del cliente:");
                idcliente = sc.next();
                System.out.println("");
                System.out.print("Ingrese la fecha de la compra:");
                fechaCompra = sc.next();
                System.out.println("");
                String reserva = sr.Reservar(inicio, fin, idcliente, fechaCompra);
                System.out.println(reserva);
                break;

            default:
                System.out.println("Opcion invalida");
        }

    }

}

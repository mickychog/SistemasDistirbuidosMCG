package usfx.pagosruat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;


public class ClienteUsuario {

    public static void main(String[] args)  {
    
        Scanner sc = new Scanner(System.in);
        int port = 5002;
        int ci = 0;
        
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            System.out.println("introduce el numero de CI: ");
            String cadena = sc.nextLine();
            toServer.println(cadena);

            ci = Integer.parseInt(cadena);
            if (ci != 0) {
                int op = 0;
                while (op != 3) {
                    mostrarMenu();
                    op = sc.nextInt();

                    switch (op) {
                        case 1:
                            toServer.println("CONSULTAR");
                            String respuestaConsulta = fromServer.readLine();
                            System.out.println("Deudas:");
                            System.out.println(respuestaConsulta);
                            break;
                        case 2:
                            toServer.println("PAGAR");
                            String respuestaPago = fromServer.readLine();
                            System.out.println("Resultado del pago:");
                            System.out.println(respuestaPago);
                            break;
                        case 3:
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    }
                }
            } else {
                System.out.println("Ingrese un CI...");
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

}

private static void mostrarMenu() {
        System.out.println("1.- Consultar Deuda");
        System.out.println("2.- pagar");
        System.out.println("3.- Salir");
        System.out.println("Elija opción:");
    }
}

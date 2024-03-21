/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package usfx.laboratorio3_rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IBanco banco;
        try {

            banco = (IBanco) Naming.lookup("rmi://localhost/Banco"); // instanciar un objeto remoto
            int opcion;
            do {
                System.out.println("Menu:");
                System.out.println("1. Mostrar Facturas");
                System.out.println("2. Pagar Facturas");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Facturas del cliente 1:");
                        Factura[] factura1 = banco.Calcular(1);
                        for (Factura f : factura1) {
                            System.out.println(f);
                        }
                        System.out.println("Facturas del cliente 2:");
                        Factura[] factura2 = banco.Calcular(2);
                        for (Factura f : factura2) {
                            System.out.println(f);
                        }
                        break;
                    case 2:
                        System.out.println("Pagar facturas...");
                        System.out.println("Seleccione qué tipo de facturas desea pagar:");
                        System.out.println("1. Pagar facturas de CESSA");
                        System.out.println("2. Pagar facturas de COTES");
                        int opcionPago = scanner.nextInt();

                        // Obtener las facturas según la opción seleccionada
                        Factura[] facturasParaPagar;
                        String tipoEmpresa = "";
                        switch (opcionPago) {
                            case 1:
                                System.out.println("Pagando facturas de CESSA...");
                                facturasParaPagar = banco.Calcular(1); // Obtener facturas de CESSA
                                tipoEmpresa = "CESSA";
                                break;
                            case 2:
                                System.out.println("Pagando facturas de COTES...");
                                facturasParaPagar = banco.Calcular(2); // Obtener facturas de COTES
                                tipoEmpresa = "COTES";
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                return;
                        }

                        // Realizar el pago con las facturas seleccionadas
                        try {
                            String respuestaPago = banco.Pagar(facturasParaPagar);
                            System.out.println("Respuesta :" + respuestaPago);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        break;
                }
            } while (opcion != 3);

            //System.out.println(banco.Pagar(factura2));
            // TODO code application logic here
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

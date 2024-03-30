package usfx.ejercicioexamenparcial;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Juez {

    private static final String SERVER_URL = "rmi://localhost/Asfi";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IAsfi asfi;
        ArrayList<Cuenta> lista = null;

        try {
            asfi = (IAsfi) Naming.lookup(SERVER_URL);

            int op = 0;
            while (op != 3) {
                mostrarMenu();
                op = sc.nextInt();

                switch (op) {
                    case 1:
                        lista = consultarCuentas(sc, asfi);
                        break;
                    case 2:
                        retenerMonto(sc, asfi, lista);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            }

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Juez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void mostrarMenu() {
        System.out.println("1.- Consultar Cuentas");
        System.out.println("2.- Retener Monto");
        System.out.println("3.- Salir");
        System.out.println("Elija opción:");
    }

    private static ArrayList<Cuenta> consultarCuentas(Scanner sc, IAsfi asfi) throws RemoteException {
        System.out.println("Introduzca CI:");
        String ci = sc.next();
        System.out.println("Introduzca Nombres:");
        String nombres = sc.next();
        System.out.println("Introduzca Apellidos:");
        String apellidos = sc.next();

        if (ci.isEmpty() || nombres.isEmpty() || apellidos.isEmpty()) {
            System.out.println("Por favor, ingrese todos los campos.");
            return null;
        }

        ArrayList<Cuenta> lista = asfi.ConsultarCuentas(ci, nombres, apellidos);
        if (lista != null && !lista.isEmpty()) {
            System.out.println("Cuentas encontradas:");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + ". " + lista.get(i));
            }
        } else {
            System.out.println("No se encontraron cuentas.");
        }
        return lista;
    }

    private static void retenerMonto(Scanner sc, IAsfi asfi, ArrayList<Cuenta> lista) throws RemoteException {
        if (lista != null && !lista.isEmpty()) {
            System.out.println("Introduzca el número de cuenta que quiere retener:");
            int numCuenta = sc.nextInt();
            boolean cuentaEncontrada = false;
            for (Cuenta cuenta : lista) {
                if (cuenta.getNrocuenta().equals(String.valueOf(numCuenta))) {
                    cuentaEncontrada = true;
                    System.out.println("Introduzca el monto a retener:");
                    double monto_retener = sc.nextDouble();
                    System.out.println("Introduzca la glosa explicando el motivo de la retención:");
                    String glosa_retener = sc.next();

                    if (asfi.RetenerMonto(cuenta, monto_retener, glosa_retener)) {
                        System.out.println("Se retuvo el monto de " + monto_retener + " en la cuenta " + cuenta.getNrocuenta()
                                + " del Banco " + cuenta.getBanco() + " por la siguiente glosa: " + glosa_retener);

                        // Actualizar las cuentas después de retener el monto
                        lista = asfi.ConsultarCuentas(cuenta.getCi(), cuenta.getNombres(), cuenta.getApellidos());

                        // Actualizar el saldo en la lista de cuentas
                        for (Cuenta updatedCuenta : lista) {
                            if (updatedCuenta.getNrocuenta().equals(String.valueOf(numCuenta))) {
                                updatedCuenta.setSaldo(updatedCuenta.getSaldo() - monto_retener);
                                System.out.println("El saldo actualizado de la cuenta " + numCuenta + " es: " + updatedCuenta.getSaldo());
                                break;
                            }
                        }
                    } else {
                        System.out.println("No es posible retener el monto");
                    }
                    break;
                }
            }
            if (!cuentaEncontrada) {
                System.out.println("El número de cuenta seleccionado no es válido.");
            }
        } else {
            System.out.println("Primero consulte las cuentas.");
        }
    }

}

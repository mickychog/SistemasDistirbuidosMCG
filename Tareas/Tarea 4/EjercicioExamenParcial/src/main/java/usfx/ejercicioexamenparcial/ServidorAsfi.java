/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.ejercicioexamenparcial;

/**
 *
 * @author micky
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServidorAsfi extends UnicastRemoteObject implements IAsfi {

    public ServidorAsfi() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> ConsultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        // Consultar cuentas en el Banco Mercantil
        ArrayList<Cuenta> cuentasMercantil = CuentasMercantil(ci, nombres, apellidos);
        if (cuentasMercantil == null || cuentasMercantil.isEmpty()) {
            throw new RemoteException("Error al consultar cuentas en el Banco Mercantil");
        }
        cuentas.addAll(cuentasMercantil);

        // Consultar cuentas en el Banco BCP
        ArrayList<Cuenta> cuentasBCP = CuentasBCP(ci, nombres, apellidos);
        if (cuentasBCP == null || cuentasBCP.isEmpty()) {
            throw new RemoteException("Error al consultar cuentas en el Banco BCP");
        }
        cuentas.addAll(cuentasBCP);

        return cuentas;
    }

    @Override
    public Boolean RetenerMonto(Cuenta cuenta, double monto, String glosa) throws RemoteException {
        boolean aux = false;

        // Retener monto en el Banco correspondiente a la cuenta
        if (cuenta.getBanco() == Banco.Mercantil) {
            aux = RetenerMercantil(cuenta, monto, glosa);
        } else if (cuenta.getBanco() == Banco.BCP) {
            aux = RetenerBCP(cuenta, monto, glosa);
        }

        return aux;
    }

    private ArrayList<Cuenta> CuentasMercantil(String ci, String nombres, String apellidos) {
        ArrayList<Cuenta> aux = new ArrayList<Cuenta>();
        int puerto = 6789;

        try {
            // Crear socket para la comunicación con el servidor Mercantil
            DatagramSocket socketUDP = new DatagramSocket();

            // Construir mensaje de solicitud
            String dato = "Buscar:" + ci + "-" + nombres + "-" + apellidos;
            byte[] mensaje = dato.getBytes();
            InetAddress hostServidor = InetAddress.getByName("localhost");
            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, puerto);

            // Enviar la solicitud al servidor Mercantil
            socketUDP.send(peticion);

            // Preparar el paquete para recibir la respuesta del servidor Mercantil
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);

            // Recibir la respuesta del servidor Mercantil
            socketUDP.receive(respuesta);

            // Procesar la respuesta y agregar las cuentas encontradas a la lista
            String respuestaStr = new String(respuesta.getData(), 0, respuesta.getLength());
            if (!respuestaStr.equals("no:encontrado")) {
                String[] cuentas = respuestaStr.split(":");
                for (String c : cuentas) {
                    String[] datos = c.split("-");
                    double saldo = Double.parseDouble(datos[1]);
                    Cuenta nueva = new Cuenta(Banco.Mercantil, datos[0], ci, nombres, apellidos, saldo);
                    aux.add(nueva);
                }
            }

            // Cerrar el socket
            socketUDP.close();
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }

        return aux;
    }

    private ArrayList<Cuenta> CuentasBCP(String ci, String nombres, String apellidos) {
        ArrayList<Cuenta> aux = new ArrayList<Cuenta>();
        int puerto = 5002;

        try {
            // Crear conexión con el servidor BCP
            Socket socketBCP = new Socket("localhost", puerto);
            PrintStream toServer = new PrintStream(socketBCP.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socketBCP.getInputStream()));

            // Enviar solicitud de búsqueda al servidor BCP
            toServer.println("Buscar:" + ci + "-" + nombres + "-" + apellidos);
            toServer.flush(); // Asegurar que el mensaje se envíe correctamente

            // Leer la respuesta del servidor BCP
            String respuesta = fromServer.readLine();
            socketBCP.close();

            // Procesar la respuesta y agregar las cuentas encontradas a la lista
            if (respuesta != null && !respuesta.isEmpty()) {
                String[] cuentas = respuesta.split(":");
                for (String c : cuentas) {
                    String[] datos = c.split("-");
                    double saldo = Double.parseDouble(datos[1]);
                    Cuenta nueva = new Cuenta(Banco.BCP, datos[0], ci, nombres, apellidos, saldo);
                    aux.add(nueva);
                }
            }
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }

        return aux;
    }

    public static void main(String[] args) {
        try {
            ServidorAsfi servidor = new ServidorAsfi();
            LocateRegistry.createRegistry(1099);
            Naming.bind("Asfi", servidor);
            System.out.println("El servidor está listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean RetenerMercantil(Cuenta cuenta, double monto, String glosa) {
        // Verificar si el monto a retener es mayor que el saldo actual de la cuenta
        if (monto > cuenta.getSaldo()) {
            System.out.println("No es posible retener el monto. Saldo insuficiente.");
            return false;
        }

        // Calcular el nuevo saldo luego de la retención
        double saldoActualizado = cuenta.getSaldo() - monto;
        cuenta.setSaldo(saldoActualizado);

        // Mostrar un mensaje con la glosa proporcionada
        System.out.println("Se retuvo el monto de " + monto + " en la cuenta " + cuenta.getNrocuenta()
                + " del Banco Mercantil por la siguiente glosa: " + glosa + " el nuevo saldo es" + cuenta.getSaldo());

        return true; // Indicar que la retención se realizó con éxito
    }

    private boolean RetenerBCP(Cuenta cuenta, double monto, String glosa) {
        // Verificar si el monto a retener es mayor que el saldo actual de la cuenta
        if (monto > cuenta.getSaldo()) {
            System.out.println("No es posible retener el monto. Saldo insuficiente.");
            return false;
        }

        // Calcular el nuevo saldo luego de la retención
        double saldoActualizado = cuenta.getSaldo() - monto;
        cuenta.setSaldo(saldoActualizado);

        // Mostrar un mensaje con la glosa proporcionada
        System.out.println("Se retuvo el monto de " + monto + " en la cuenta " + cuenta.getNrocuenta()
                + " del Banco BCP por la siguiente glosa: " + glosa + " el nuevo saldo es" + cuenta.getSaldo());

        return true; // Indicar que la retención se realizó con éxito
    }

}

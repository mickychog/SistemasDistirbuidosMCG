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
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBCP {

    public static void main(String[] args) {
        int port = 5002;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Servidor del Banco BCP iniciado con éxito");

            while (true) {
                Socket client = server.accept();
                System.out.println("Cliente se conectó");

                // Preparar entrada y salida para el cliente
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintStream toClient = new PrintStream(client.getOutputStream());

                // Recibir la solicitud del cliente
                String solicitud = fromClient.readLine();

                // Procesar la solicitud y enviar la respuesta al cliente
                String respuesta = buscarCuentas(solicitud);
                toClient.println(respuesta);

                // Cerrar conexión con el cliente
                client.close();
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static String buscarCuentas(String solicitud) {
        // Lógica para buscar cuentas en el Banco BCP
        String[] comandos = solicitud.split(":");
        String[] datos = comandos[1].split("-");
        String ci = datos[0];
        String nombres = datos[1];
        String apellidos = datos[2];

        if (ci.equals("7687682") && nombres.equals("Juan") && apellidos.equals("Segovia")) {
            return "657654-2000";
        } else if (ci.equals("455787") && nombres.equals("Ricardo") && apellidos.equals("Centellas")) {
            return "657255-5890";
        } else {
            return "no:encontrado";
        }
    }
}

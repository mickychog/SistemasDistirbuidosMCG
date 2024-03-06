/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package usfx.ejercicio_3_soquet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

/**
 *
 * @author micky
 */
public class ServerTCP {
    private static final int PORT = 5002;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Se inició el servidor con éxito");

            while (true) {
                Socket client = server.accept();
                PrintStream toClient = new PrintStream(client.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));

                System.out.println("Cliente se conectó");

                String url = fromClient.readLine();
                System.out.println("URL recibida: " + url);

                String resultado = checkWebsiteAvailability(url);

                toClient.println(resultado);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String checkWebsiteAvailability(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar la conexion
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return "El sitio web está disponible.";
            } else {
                return "El sitio web no está disponible. Código de respuesta: " + responseCode;
            }
        } catch (IOException e) {
            return "Error al verificar la disponibilidad del sitio web: " + e.getMessage();
        }
    }
}
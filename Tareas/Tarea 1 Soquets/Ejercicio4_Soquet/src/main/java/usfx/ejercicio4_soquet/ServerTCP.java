/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package usfx.ejercicio4_soquet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.HttpURLConnection;
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
            System.out.println("Servidor iniciado. Esperando solicitudes...");

            while (true) {
                Socket client = server.accept();
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintStream toClient = new PrintStream(client.getOutputStream());

                String fileName = fromClient.readLine();
                boolean fileFound = searchFile(fileName);
              
                if (fileFound) {
                    toClient.println("El archivo '" + fileName + "' se encontró en el servidor.");
                } else {
                    toClient.println("El archivo '" + fileName + "' no se encontró en el servidor.");
                }
            }
        } catch (IOException ex) {
            System.out.println("Error en el servidor: " + ex.getMessage());
        }
    }

    private static boolean searchFile(String fileName) {
    try {
        // Construir la URL completa para el archivo en el servidor local
        String fileUrl = "http://localhost/" + fileName;
        System.out.println("URL del archivo: " + fileUrl);

        // Crear una conexión HTTP y establecer el método HEAD
        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");

        // Obtener el código de respuesta
        int responseCode = connection.getResponseCode();
        System.out.println("Código de respuesta: " + responseCode);

        // Comprobar si el archivo existe (código de respuesta 200 OK)
        return responseCode == HttpURLConnection.HTTP_OK;
    } catch (IOException e) {
        // Manejar excepciones
        System.out.println("Error al buscar el archivo: " + e.getMessage());
        return false;
    }
}
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.lab3_ejercicio2;

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
import java.util.Random;

public class ServerTCP {

    private static final String[] PALABRAS = {"CASA", "AUTO", "PERRO", "GATO", "CIELO", "ARBOL", "SOL"};

    public static void main(String[] args) {
        int port = 5002;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con exito");

            while (true) {
                Socket client = server.accept();
                System.out.println("Cliente se conecto");

                Random random = new Random();
                String palabraSeleccionada = PALABRAS[random.nextInt(PALABRAS.length)];

                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintStream toClient = new PrintStream(client.getOutputStream());

                String nombreCliente = fromClient.readLine();
                System.out.println("Cliente: " + nombreCliente);

                toClient.println("BIENVENIDO, " + nombreCliente.toUpperCase() + "! Comienza el juego del ahorcado.");

                jugarAhorcado(palabraSeleccionada, fromClient, toClient);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void jugarAhorcado(String palabra, BufferedReader fromClient, PrintStream toClient) throws IOException {
        int intentos = palabra.length();
        char[] palabraAdivinada = new char[palabra.length()];
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }

        while (intentos > 0 && !String.valueOf(palabraAdivinada).equals(palabra)) {
            toClient.println(obtenerEstadoJuego(palabraAdivinada, intentos));
            String letra = fromClient.readLine().toUpperCase();
            if (letra.length() == 1) {
                char charLetra = letra.charAt(0);
                boolean letraAdivinada = false;
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == charLetra) {
                        palabraAdivinada[i] = charLetra;
                        letraAdivinada = true;
                        intentos--;
                    }
                }
                if (!letraAdivinada) {
                    intentos--;
                }
            } else {
                toClient.println("ERROR: Debe ingresar solo una letra.");
            }
        }

        
        if (String.valueOf(palabraAdivinada).equals(palabra)) {
            toClient.println("¡Felicidades, GANASTE!!");
        } else {
            toClient.println("PERDISTE!! La palabra correcta era: " + palabra);
        }
        toClient.println(obtenerEstadoJuego(palabraAdivinada, intentos));

    }

    private static String obtenerEstadoJuego(char[] palabraAdivinada, int intentos) {
        StringBuilder estado = new StringBuilder();
        for (char c : palabraAdivinada) {
            estado.append(c).append(" ");
        }
        estado.append(":").append(intentos);
        return estado.toString();
    }
}

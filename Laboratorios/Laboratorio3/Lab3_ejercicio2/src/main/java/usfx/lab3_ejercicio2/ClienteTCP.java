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
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

    public static void main(String[] args) {
        int port = 5002;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese su nombre: ");
            String nombre = scanner.nextLine();

            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            toServer.println(nombre);

            System.out.println(fromServer.readLine());

            while (true) {

                String estadoJuego = fromServer.readLine();
                System.out.println(estadoJuego);

                if (estadoJuego.contains("GANASTE") || estadoJuego.contains("PERDISTE")) {
                    break; 
                }

                System.out.print("Ingrese una letra: ");
                String letra = scanner.nextLine();
                toServer.println(letra);

                if (estadoJuego.contains("¡Felicidades!") || estadoJuego.contains("¡Lo siento!")) {
                    break;
                }
            }

            client.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

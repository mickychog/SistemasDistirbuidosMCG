package usfx.ejercicio2_soquet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int port = 5002;

        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            System.out.println("Introduce la palabra o frase a traducir(en español):");
            String palabra = sc.nextLine();
            toServer.println(palabra);

            // La respuesta del servidor será la traducción
            String traduccion = fromServer.readLine();
            System.out.println(traduccion);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

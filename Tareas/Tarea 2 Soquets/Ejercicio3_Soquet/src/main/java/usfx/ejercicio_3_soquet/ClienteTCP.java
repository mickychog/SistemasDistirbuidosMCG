package usfx.ejercicio_3_soquet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author micky
 */
public class ClienteTCP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int port = 5002;

        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            System.out.println("Introduce la URL del sitio web:");
            String url = sc.nextLine();
            toServer.println(url);

            String resultado = fromServer.readLine();
            System.out.println("Resultado recibido: " + resultado);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
package usfx.ejercicio4_soquet;

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

            System.out.println("Introduce el nombre del archivo a buscar:");
            String fileName = sc.nextLine();
            toServer.println(fileName);

            String response = fromServer.readLine();
            System.out.println(response);
        } catch (IOException ex) {
            System.out.println("Error en el cliente: " + ex.getMessage());
        }
    }
}
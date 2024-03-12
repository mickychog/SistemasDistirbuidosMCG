/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usfx.lab3_ejercicio3;

/**
 *
 * @author micky
 */
// Java implementation for a client
// Save file as Client.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteMultihilo {

    public static void main(String[] args) {
        try {
            Scanner scn = new Scanner(System.in);

            // Obtener la dirección IP del servidor
            InetAddress ip = InetAddress.getByName("localhost");

            // Establecer la conexión con el servidor en el puerto 5056
            Socket s = new Socket(ip, 5056);

            // Obtener los flujos de entrada y salida
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // Crear un hilo para recibir mensajes del servidor y otros clientes
            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        String received = dis.readUTF();
                        System.out.println(received);
                    }
                } catch (IOException e) {
                    System.out.println("Conexión con el servidor cerrada.");
                }
            });
            receiveThread.start();

            // El siguiente bucle realiza el intercambio de información entre el cliente y el servidor
            while (true) {
    System.out.println(dis.readUTF());
    String option = scn.nextLine();
    dos.writeUTF(option);

    switch (option) {
        case "1":
        case "2":
            System.out.println(dis.readUTF());

            // Ejecutar la entrada del usuario en un hilo separado
            Thread inputThread = new Thread(() -> {
                try {
                    String taskInput = scn.nextLine();
                    dos.writeUTF(taskInput);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            inputThread.start();
            break;
        default:
            System.out.println("Opción no válida. Por favor, intente de nuevo.");
            break;
    }
}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

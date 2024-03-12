/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usfx.lab2_ejercicio1;

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

            InetAddress ip = InetAddress.getByName("localhost");

            Socket s = new Socket(ip, 5056);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        String received = dis.readUTF();
                        System.out.println("Servidor=> " + received);
                    }
                } catch (IOException e) {
                    System.out.println("Conexión con el servidor cerrada.");
                }
            });
            receiveThread.start();

            while (true) {
                //System.out.println("Ingrese un mensaje:");
                String tosend = scn.nextLine();
                dos.writeUTF(tosend);

                if (tosend.equals("salir")) {
                    System.out.println("Cerrando conexión: " + s);
                    break;
                }

                // Leer y mostrar la respuesta del servidor
                String received = dis.readUTF();
                System.out.println("Servidor: " + received);
            }

            scn.close();
            dis.close();
            dos.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


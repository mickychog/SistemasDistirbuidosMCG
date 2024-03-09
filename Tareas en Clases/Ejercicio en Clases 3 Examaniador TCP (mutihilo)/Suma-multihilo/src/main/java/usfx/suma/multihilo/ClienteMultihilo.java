/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usfx.suma.multihilo;

/**
 *
 * @author Carlos
 */
// Java implementation for a client
// Save file as Client.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

// Client class
public class ClienteMultihilo {

    public static void main(String[] args) throws IOException {
        try {
            Scanner scn = new Scanner(System.in);

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            // establish the connection with server port 5056
            Socket s = new Socket(ip, 5056);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // the following loop performs the exchange of
            // information between client and client handler
            while (true) {
                System.out.println(dis.readUTF());
                String tosend = scn.nextLine();
                dos.writeUTF(tosend);

                // If client sends exit,close this connection
                // and then break from the while loop
                if (tosend.equals("salir")) {
                    System.out.println("Cerrando conexion : " + s);
                    s.close();
                    System.out.println("Conexion cerrada");
                    break;
                }

                // printing date or time as requested by client
                String received = dis.readUTF();
                System.out.println("Servidor: " + received);
                System.out.println("Respuesta : ");
                if (received.equals("salir")) {
                    System.out.println("Cerrando conexion : " + s);
                    s.close();
                    System.out.println("Conexion cerrada");
                    break;
                }
                
                String tosend1 = scn.nextLine();
                dos.writeUTF(tosend1);
                String received1 = dis.readUTF();
                System.out.println( received1);
                System.out.println("Presiona Enter para continuar...");
                scn.nextLine();
            }

            // closing resources
            scn.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

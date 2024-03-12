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
// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ServerMultihilo {

    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5056);
        System.out.println("Esperando clientes...");

        while (true) {
            Socket s = ss.accept();
            System.out.println("Nuevo cliente conectado: " + s);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            ClientHandler clientHandler = new ClientHandler(s, dis, dos, clients);
            clients.add(clientHandler);

            Thread t = new Thread(clientHandler);
            t.start();
        }
    }

    static List<ClientHandler> getClients() {
        return clients;
    }

    static void broadcastTaskLists() {
        for (ClientHandler client : clients) {
            try {
                if (!client.clientSocket.isClosed()) {
                    client.sendTaskList("Lista de tareas:\n" + client.getTaskList());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


package usfx.lab2_ejercicio1;

import java.io.*;
import java.net.*;
import java.util.List;

public class ClientHandler extends Thread {
    
    private final List<ClientHandler> clients;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final Socket s;

    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, List<ClientHandler> clients) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            while (true) {
                dos.writeUTF("Ingrese el mensaje:");
                String message = dis.readUTF();

                if (message.equals("salir")) {
                    System.out.println("Cliente " + s + " ha cerrado la conexión.");
                    s.close();
                    removeClient(this);
                    break;
                }

                // Transmitir el mensaje a todos los clientes conectados
                broadcast(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcast(String message) {
        for (ClientHandler client : clients) {
            try {
                if (client != this && !client.s.isClosed()) {
                    client.dos.writeUTF(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }
}

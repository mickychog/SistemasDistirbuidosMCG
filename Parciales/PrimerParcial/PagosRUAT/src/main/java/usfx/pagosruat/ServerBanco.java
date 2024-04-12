/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.pagosruat;

/**
 *
 * @author micky
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerBanco {

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        
        //IRuat saludo;
        //saludo = (IRuat) Naming.lookup("rmi://localhost/Saludo"); // instanciar un objeto remoto
        //System.out.println(saludo.HolaMundo());
    
        //Registry registry = LocateRegistry.getRegistry(1099); // Puerto default del registro RMI
          //  IRuat ruat = (IRuat) registry.lookup("Ruat");
        
        int port = 5002;
        int ci=0;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Servidor del Banco iniciado con éxito");

            while (true) {
                Socket client = server.accept();
                System.out.println("Cliente se conectó");

                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintStream toClient = new PrintStream(client.getOutputStream());
                   
                String recibido = fromClient.readLine();
                ci=Integer.parseInt(recibido);
                System.out.println("CI recibido "+ci);
                
                client.close();
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//realizar un programa que utilizando la tecnologia sockets TCP,pueda simular el funcionamiento de una calculadora par 2 numeros
//el cliente mandara una cadena con la operacion y el servidor respondera la solucion
//Ej: cliente "3+4 servidor "7" 
//Ej: cliente "5-3" servidor 2
//solo dos digitos y solo las operaciones +,-,*,/
package usfx.ejercicio1_soquet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Micky
 */
public class ServerTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int port = 5002;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            while (true){
            Socket client;
            PrintStream toClient;
            client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            String recibido = fromClient.readLine();
            System.out.println(recibido);
            try {
                
                String[] partes = recibido.split("[+\\-*/]");
                int numero1 = Integer.parseInt(partes[0]);
                int numero2 = Integer.parseInt(partes[1]);


                String operador = recibido.replaceAll("[0-9]", "");
                
                Operaciones operaciones = new Operaciones(0, 0);

                operaciones.setA(numero1);
                operaciones.setB(numero2);


                float resultado = operaciones.realizarOperacion(operador);
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(resultado + "\n");
                System.out.println("Resutado:" + resultado);
            } catch (Exception e) {

            toClient = new PrintStream(client.getOutputStream());
            toClient.println("Error");
            }
            toClient = new PrintStream(client.getOutputStream());
            toClient.println(recibido + "\n");
        }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

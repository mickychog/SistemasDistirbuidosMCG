/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usfx.lab3_ejercicio1;

import java.net.*;
import java.io.*;

public class ClientUDP {

    public static void main(String args[]) {
        int puerto = 6789;
        try {
            DatagramSocket socketUDP = new DatagramSocket();
            BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("**************************************");
                System.out.println("Seleccione una opcion:");
                System.out.println("1. Verificar si un numero es primo");
                System.out.println("2. Salir");
                System.out.print("Opción: ");
                String opcion = entradaUsuario.readLine();

                if (opcion.equals("1")) {
                                        System.out.print("Ingrese un numero: ");
                    String dato = entradaUsuario.readLine();
                    byte[] mensaje = dato.getBytes();
                    InetAddress hostServidor = InetAddress.getByName("localhost");

                    DatagramPacket peticion = new DatagramPacket(mensaje, dato.length(), hostServidor, puerto);
                    socketUDP.send(peticion);

                    byte[] buffer = new byte[1000];
                    DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
                    socketUDP.receive(respuesta);

                    String respuestaServidor = new String(respuesta.getData(), 0, respuesta.getLength());
                    System.out.println("Respuesta del servidor: " + respuestaServidor);
                } else if (opcion.equals("2")) {
                    break;
                } else {
                    System.out.println("Opción inválida. Por favor, seleccione 1 o 2.");
                }
            }

            socketUDP.close();
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}

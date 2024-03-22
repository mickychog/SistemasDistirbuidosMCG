/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usfx.lab3_ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUDP {

    public static boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int port = 6789;
        try {
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] buffer = new byte[1000];

            while (true) {
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                socketUDP.receive(peticion);

                String cadena = new String(peticion.getData(), 0, peticion.getLength());
                int valor = Integer.parseInt(cadena.trim());

                boolean primo = esPrimo(valor);

                String respuesta = primo ? "ES PRIMO" : "NO ES PRIMO";
                byte[] mensajeRespuesta = respuesta.getBytes();

                DatagramPacket respuestaPacket = new DatagramPacket(mensajeRespuesta, mensajeRespuesta.length,
                        peticion.getAddress(), peticion.getPort());
                socketUDP.send(respuestaPacket);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}

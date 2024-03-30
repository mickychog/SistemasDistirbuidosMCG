/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usfx.ejercicioexamenparcial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerMercantil {

    public static void main(String args[]) {
        int port = 6789;
        try {
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);
                String solicitud = new String(peticion.getData(), 0, peticion.getLength());

                // Procesamos la solicitud y preparamos la respuesta
                String respuesta = buscarCuentas(solicitud);
                byte[] mensaje = respuesta.getBytes();

                // Construimos el DatagramPacket para enviar la respuesta
                DatagramPacket respuestaDatagrama = new DatagramPacket(mensaje, mensaje.length,
                        peticion.getAddress(), peticion.getPort());

                // Enviamos la respuesta
                socketUDP.send(respuestaDatagrama);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String buscarCuentas(String solicitud) {
        // Lógica para buscar cuentas en el Banco Mercantil
        String[] comandos = solicitud.split(":");
        String[] datos = comandos[1].split("-");
        String ci = datos[0];
        String nombres = datos[1];
        String apellidos = datos[2];

        if (ci.equals("7687682") && nombres.equals("Juan") && apellidos.equals("Segovia")) {
            return "1112450-50000";
        } else if (ci.equals("54654") && nombres.equals("Maria") && apellidos.equals("Parra")) {
            return "1121454-3000";
        } else {
            return "no:encontrado";
        }
    }
}

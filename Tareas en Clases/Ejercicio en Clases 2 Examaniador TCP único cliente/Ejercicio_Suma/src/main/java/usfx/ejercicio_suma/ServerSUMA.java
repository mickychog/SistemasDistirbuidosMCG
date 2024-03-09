package usfx.ejercicio_suma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSUMA {

    static int respuestaMandar;

    public static void main(String[] args) {
        int port = 5002;//declaramos puerto
        ServerSocket server;//
        try {
            server = new ServerSocket(port);
            System.out.println("Servidor creado....");
            while (true) {

                Socket client = server.accept();
                System.out.println("Cliente se conecto....");

                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                PrintStream toClient = new PrintStream(client.getOutputStream());
                String solicitud;
                while ((solicitud = fromClient.readLine()) != null && !solicitud.equals("salir")) {
                    String resultadoPeticion = procesarPeticion(solicitud);
                    toClient.println(resultadoPeticion);
                    String recibido1 = fromClient.readLine();
                    System.out.println("Respuesta del cliente:" + recibido1);
                    int respuestaCliente = Integer.parseInt(recibido1);
                    String respuesta3;
                    if (respuestaCliente == respuestaMandar) {
                        respuesta3 = "resp: Correcto";
                    } else {
                        respuesta3 = "resp:  Incorrecto!";
                    }
                    toClient.println(respuesta3);
                }
                server.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public static String procesarPeticion(String s) {

        String[] solicitudProcesada = s.split(":");
        if (solicitudProcesada.length < 2) {
            return "resp: Formato de solicitud incorrecto";
        }

        if (solicitudProcesada[1].equals("sumar")) {
            int vara = (int) (Math.round(Math.random() * 100));
            int varb = (int) (Math.round(Math.random() * 100));
            respuestaMandar = vara + varb;
            return vara + "+" + varb;
        }
        if (solicitudProcesada[1].equals("restar")) {
            int vara = (int) (Math.round(Math.random() * 100));
            int varb = (int) (Math.round(Math.random() * 100));
            respuestaMandar = vara - varb;
            return vara + "-" + varb;
        }
        if (solicitudProcesada[1].equals("multiplicar")) {
            int vara = (int) (Math.round(Math.random() * 100));
            int varb = (int) (Math.round(Math.random() * 100));
            respuestaMandar = vara * varb;
            return vara + "*" + varb;
        }
        if (solicitudProcesada[1].equals("dividir")) {
            int vara = (int) (Math.round(Math.random() * 100));
            int varb = (int) (Math.round(Math.random() * 100));
            respuestaMandar = vara / varb;
            return vara + "/" + varb;
        } else {
            return "Operacion no existe";
        }
    }
}

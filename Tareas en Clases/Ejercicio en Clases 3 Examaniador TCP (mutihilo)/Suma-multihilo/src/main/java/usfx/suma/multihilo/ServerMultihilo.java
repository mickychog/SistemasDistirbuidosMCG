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
// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

// Server class
public class ServerMultihilo {

    private static int respuestaMandar;

    //static int respuestaMandar;
    public static void main(String[] args) throws IOException {
        // Escuchandoen el puerto 5056
        ServerSocket ss = new ServerSocket(5056);
        System.out.println("Esperando clientes...");
        //ciclo al infinito
        while (true) {
            Socket s = null;

            try {
                // Coneccion del cliente
                s = ss.accept();

                System.out.println("Un nuevo cliente se ha conectado : " + s);

                // obtener su entrada y salida de stream
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Asignar un nuevo hilo para este cliente ");

                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos);

                // Invoking the start() method
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }

//    public static String procesarPeticion(String s) {
//        String[] solicitudProcesada = s.split(":");
//        
//        if (solicitudProcesada[1].equals("sumar")) {
//            int vara = (int) (Math.round(Math.random() * 100));
//            int varb = (int) (Math.round(Math.random() * 100));
//            String operacion = "+";
//            respuestaMandar = vara + varb;
//            return vara + " + " + varb;
//        }
//        if (solicitudProcesada[1].equals("restar")) {
//            int vara = (int) (Math.round(Math.random() * 100));
//            int varb = (int) (Math.round(Math.random() * 100));
//            String operacion = "-";
//            respuestaMandar = vara - varb;
//            return vara + "-" + varb;
//        }
//        if (solicitudProcesada[1].equals("multiplicar")) {
//            int vara = (int) (Math.round(Math.random() * 100));
//            int varb = (int) (Math.round(Math.random() * 100));
//            respuestaMandar = vara * varb;
//            return vara + "*" + varb;
//        }
//        if (solicitudProcesada[1].equals("dividir")) {
//            int vara = (int) (Math.round(Math.random() * 100));
//            int varb = (int) (Math.round(Math.random() * 100));
//            respuestaMandar = vara / varb;
//            return vara + "/" + varb;
//        } else {
//            return "Operacion no existe";
//        }
//    }
//
//    public static int getRespuestaMandar() {
//        return respuestaMandar;
//    }
}

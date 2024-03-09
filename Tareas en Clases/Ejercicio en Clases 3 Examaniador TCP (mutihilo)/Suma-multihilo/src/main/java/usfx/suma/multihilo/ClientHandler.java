package usfx.suma.multihilo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends Thread {

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    int respuestaMandar;

    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String toreturn;
        int vara, varb;

        while (true) {
            try {
                // Ask user what he wants
                dos.writeUTF("Introduce según protocolo: salir \n"
                        + "* iniciar:sumar \n"
                        + "* iniciar:restar \n"
                        + "* iniciar:multiplicar\n"
                        + "* iniciar:dividir \n"
                        + "* Escribir 'salir' para terminar la conexión.");

                // receive the answer from client
                String received = dis.readUTF();
                System.out.println(received);

                if (received.equals("salir")) {
                    System.out.println("Cliente " + this.s + " envió 'salir'.");
                    System.out.println("Cerrando esta conexión.");
                    this.s.close();
                    System.out.println("Conexión cerrada");
                    break;
                }
                String[] solicitudProcesada = received.split(":");
                if (solicitudProcesada.length == 2) {
                    switch (solicitudProcesada[1]) {
                        case "sumar":
                            vara = (int) (Math.round(Math.random() * 100));
                            varb = (int) (Math.round(Math.random() * 100));
                            respuestaMandar = vara + varb;
                            toreturn = vara + " + " + varb;
                            dos.writeUTF(toreturn);
                            break;
                        case "restar":
                            vara = (int) (Math.round(Math.random() * 100));
                            varb = (int) (Math.round(Math.random() * 100));
                            respuestaMandar = vara - varb;
                            toreturn = vara + " - " + varb;
                            dos.writeUTF(toreturn);
                            break;

                        case "multiplicar":
                            vara = (int) (Math.round(Math.random() * 100));
                            varb = (int) (Math.round(Math.random() * 100));
                            respuestaMandar = vara * varb;
                            toreturn = vara + " * " + varb;
                            dos.writeUTF(toreturn);
                            break;

                        case "dividir":
                            vara = (int) (Math.round(Math.random() * 100));
                            varb = (int) (Math.round(Math.random() * 100));
                            respuestaMandar = vara / varb;
                            toreturn = vara + " / " + varb;
                            dos.writeUTF(toreturn);
                            break;

                        default:
                            dos.writeUTF("salir");
                            //this.s.close();
                            System.out.println("Conexión cerrada");
                            break;

                    }

                    // Recibir la respuesta del cliente
                    String recibido1 = dis.readUTF();
                    System.out.println("Respuesta del cliente: " + recibido1);

                    int respuestaCliente = Integer.parseInt(recibido1);
                    String respuesta3;

                    if (respuestaCliente == respuestaMandar) {
                        respuesta3 = "resp: Correcto";
                    } else {
                        respuesta3 = "resp: Incorrecto!";
                    }
                    dos.writeUTF(respuesta3);
                } else {
                    dos.writeUTF("salir");
                    this.s.close();
                    System.out.println("Conexión cerrada");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // Cerrar recursos
            this.dis.close();
            this.dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

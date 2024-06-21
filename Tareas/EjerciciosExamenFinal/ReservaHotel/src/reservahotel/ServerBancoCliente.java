/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservahotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerBancoCliente {

    public static void main(String[] args) {

        List<SaldoCliente> saldo = new ArrayList<>();

        saldo.add(new SaldoCliente(1, 455));
        saldo.add(new SaldoCliente(2, 300));
        saldo.add(new SaldoCliente(3, 1500));

        int port = 5002;
        ServerSocket server;

        try {

            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            while (true) {
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector

                System.out.println("Cliente se conecto");

                //Recibimos la cadena "idcliente:monto" del ServidorReserva(cotizacion)
                String cadena = fromClient.readLine();
                String cadena_split[] = cadena.split(":");
                String MensajeSaldo = buscarSaldo(saldo, Integer.parseInt(cadena_split[0]), Double.parseDouble(cadena_split[1]));

                //Mandamos el mensaje de confirmacion al clienteServidorReserva
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(MensajeSaldo);

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String buscarSaldo(List<SaldoCliente> _saldo, int _idcliente, double _monto) {
        for (SaldoCliente sd : _saldo) {
            if (sd.getidcliente() == _idcliente) {
                if (sd.getsaldo() >= _monto) {
                    return "exito:si";
                } else {
                    return "exito:no";
                }
            }
        }
        return null;
    }
}

class SaldoCliente {

    private int idcliente;
    private double saldo;

    SaldoCliente(int _idcliente, double _saldo) {
        this.idcliente = _idcliente;
        this.saldo = _saldo;
    }

    public int getidcliente() {
        return idcliente;
    }

    public double getsaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return idcliente + " tiene " + saldo + " bs";
    }
}

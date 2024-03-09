package usfx.ejercicio_suma;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSUMA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int port = 5002;
        try{

            Socket client = new Socket("localhost",port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String cadena;
            do{
                System.out.println("Introduce segun protocolo:  ");
                System.out.println("iniciar:sumar ");
                System.out.println("iniciar:restar ");
                System.out.println("iniciar:multiplicar ");
                System.out.println("iniciar:dividir ");
                System.out.println("salir ");
                cadena = sc.nextLine();
                toServer.println(cadena);//iniciar:suma

                String result = fromServer.readLine();
                System.out.println("Servidor: " + result);
                System.out.println("Envie su respuesta:");

                String cadena2 = sc.nextLine();
                toServer.println(cadena2);//enviamos al servidor

                String result2 = fromServer.readLine();
                System.out.println("Servidor" + result2);
            }while(!cadena.equals("salir"));
            toServer.println("salir");
            client.close();//enviamos al servidor
        }catch (IOException ex){
            System.out.println(ex.getMessage());

        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservahotel;

//Servicio Web
import org.tempuri.WebService;
import org.tempuri.WebServiceSoap;

//RMI
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//TCP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//REST
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class ServidorReserva extends UnicastRemoteObject implements IServidorReserva {

    protected ServidorReserva() throws RemoteException {
        super();
    }

    @Override
    public double Cotizar(String _inicio, String _fin, String _fechaCotizacion) throws RemoteException {

        List<CotizacionFechas> fecha_precio = new ArrayList<>();

        fecha_precio.add(new CotizacionFechas("02-06-24", new BigDecimal("32")));
        fecha_precio.add(new CotizacionFechas("03-06-24", new BigDecimal("26")));
        fecha_precio.add(new CotizacionFechas("04-06-24", new BigDecimal("24")));
        fecha_precio.add(new CotizacionFechas("05-06-24", new BigDecimal("30")));
        fecha_precio.add(new CotizacionFechas("06-06-24", new BigDecimal("40")));

        BigDecimal CambioDolar = obtenerCotizacion(_fechaCotizacion);
        System.out.println(CambioDolar);
        BigDecimal CantidadTotal = cotizarHotel(_inicio, _fin, fecha_precio);
        System.out.println(CantidadTotal);

        BigDecimal CotizacionFinal = CantidadTotal.multiply(CambioDolar);
        System.out.println(CotizacionFinal);

        return CotizacionFinal.doubleValue();
    }

    @Override
    public String Reservar(String _inicio, String _fin, String _idcliente, String _fechaCompra) throws RemoteException {
        Scanner sc = new Scanner(System.in);

        int port = 5002;
        String MensajeCliente = "";

        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            double cotizacionfinal = Cotizar(_inicio, _fin, _fechaCompra);
            String monto = String.valueOf(cotizacionfinal);

            String cadena = _idcliente + ":" + monto;

            //Enviamos el mensaje al servidor
            toServer.println(cadena);

            //Recibimos el mensaje del servidor
            String result = fromServer.readLine();
            String mensaje[] = result.split(":");
            if (mensaje[1].equals("si")) {
                MensajeCliente = "Compra exitosa";
                PostRest(_idcliente, _inicio, _fin);
            } else {
                MensajeCliente = "Compra fallida";
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return MensajeCliente;
    }

    //Web Service SOAP
    private static BigDecimal obtenerCotizacion(java.lang.String fecha) {
        WebService service = new WebService();
        WebServiceSoap port = service.getWebServiceSoap();
        return port.obtenerCotizacion(fecha);
    }

    // Calcular el precio total de los dias
    public static BigDecimal cotizarHotel(String inicio, String fin, List<CotizacionFechas> fecha_precio) {

        boolean Entro = false;
        BigDecimal total = BigDecimal.ZERO;

        for (CotizacionFechas cotizacion : fecha_precio) {

            String fecha = cotizacion.getfecha();

            if (fecha.equals(inicio)) {
                Entro = true;
            }
            if (Entro) {
                total = total.add(cotizacion.getprecio());
            }

            if (fecha.equals(fin)) {
                break;
            }

        }

        return total;
    }

    //Post
    public void PostRest(String _idcliente, String _fechainicio, String _fechafin) {
        try {
            // URL del servicio REST
            URL url = new URL("http://127.0.0.1:8000/api/v1/hotels");

            // Establecer la conexión
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            // Crear el JSON que queremos enviar
            String jsonInputString = String.format("{\"id_cliente\": \"%s\", \"fecha_inicio\": \"%s\", \"fecha_fin\": \"%s\"}",
                    _idcliente, _fechainicio, _fechafin);

            // Enviar el JSON en el cuerpo del POST
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Obtener la respuesta
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

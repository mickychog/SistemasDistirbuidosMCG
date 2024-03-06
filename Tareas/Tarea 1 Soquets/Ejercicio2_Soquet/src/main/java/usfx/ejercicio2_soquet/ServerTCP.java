/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//realizar un programa que utilizando la tecnologia sockets TCP,pueda simular el funcionamiento de una calculadora par 2 numeros
//el cliente mandara una cadena con la operacion y el servidor respondera la solucion
//Ej: cliente "3+4 servidor "7" 
//Ej: cliente "5-3" servidor 2
//solo dos digitos y solo las operaciones +,-,*,/
package usfx.ejercicio2_soquet;

import java.io.*;
import java.net.*;
import com.google.gson.*;
import okhttp3.*;
/**
 *
 * @author Micky
 */


public class ServerTCP {
    private static final int PORT = 5002;
    private static final String KEY = "84c6393e3b30486c9952a451251a3108";
    private static final String LOCATION = "eastus";
    private static final OkHttpClient CLIENT = new OkHttpClient();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Se inició el servidor con éxito");

            while (true) {
                Socket client = server.accept();
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Cliente se conectó");

                String palabraRecibida = fromClient.readLine();
                System.out.println("Palabra recibida: " + palabraRecibida);

                // Traducción directamente en el servidor
                String traduccion = translateText(palabraRecibida);

                // Enviar la traducción al cliente
                PrintStream toClient = new PrintStream(client.getOutputStream());
                toClient.println("Traducción: " + traduccion);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String translateText(String text) {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType,
                    "[{\"Text\": \"" + text + "\"}]");

            Request request = new Request.Builder()
                    .url("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&from=es&to=en")
                    .post(body)
                    .addHeader("Ocp-Apim-Subscription-Key", KEY)
                    .addHeader("Ocp-Apim-Subscription-Region", LOCATION)
                    .addHeader("Content-type", "application/json")
                    .build();

            Response response = CLIENT.newCall(request).execute();
            return extractTranslation(response.body().string());
        } catch (IOException e) {
            return "Error en la traducción";
        }
    }

    private static String extractTranslation(String jsonResponse) {
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(jsonResponse).getAsJsonArray();
        JsonObject translationObject = jsonArray.get(0).getAsJsonObject();
        JsonArray translations = translationObject.getAsJsonArray("translations");
        JsonObject translation = translations.get(0).getAsJsonObject();
        return translation.get("text").getAsString();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.laboratorio1;

/**
 *
 * @author micky
 */
import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su peso en kilogramos: ");
        double peso = scanner.nextDouble();

        System.out.print("Ingrese su altura en metros: ");
        double altura = scanner.nextDouble();

        double imc = calcularIMC(peso, altura);

        System.out.println("Su IMC es: " + imc);
        
        String clasificacion = RangosIMC.clasificar(imc);
        System.out.println("Clasificación del IMC: " + clasificacion);
    }

    private static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.ejercicio2_soquet;

/**
 *
 * @author micky
 */
public class Operaciones {
    private int a;
    private int b;



    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int suma(){
        return this.a+this.b;
    }
    public int resta(){
        return this.a-this.b;
    }
    public int multiplicacion(){
        return this.a*this.b;
    }
    public float division(){
        if (this.b != 0) {
            return (float) this.a / this.b;
        } else {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
    }
    public int realizarOperacion(String operador) {
        switch (operador) {
            case "+":
                return suma();
            case "-":
                return resta();
            case "*":
                return multiplicacion();
            case "/":
                return (int) division();
            default:
                throw new IllegalArgumentException("Operador no válido");
        }
    }
}

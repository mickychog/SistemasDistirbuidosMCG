/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.laboratorio1;

/**
 *
 * @author micky
 */
class Contacto {
    private String nombre;
    private String numeroTelefono;

    public Contacto(String nombre, String numeroTelefono) {
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "Nombre= '" + nombre + '\'' +
                ", Telefono= '" + numeroTelefono + '\'' +
                '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.laboratorio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author micky
 */

class Agenda {
    private List<Contacto> contactos = new ArrayList<>();

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }

        public void eliminarContacto(String nombre) {
            Iterator<Contacto> iterator = contactos.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getNombre().equalsIgnoreCase(nombre)) {
                    iterator.remove();
                    System.out.println("Contacto eliminado correctamente.");
                    return;
                }
            }
            System.out.println("No se encontró el contacto con el nombre proporcionado.");
        }

    public void mostrarContactos() {
        System.out.println("=== Lista de Contactos ===");
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
        System.out.println("==========================");
    }
}

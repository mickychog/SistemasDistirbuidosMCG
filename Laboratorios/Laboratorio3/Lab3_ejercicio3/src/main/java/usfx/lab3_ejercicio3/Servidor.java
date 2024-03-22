/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.lab3_ejercicio3;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author micky
 */
public class Servidor {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {

        Operaciones operaciones = new Operaciones();
        LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
        Naming.bind("Operaciones", operaciones);
    }

}

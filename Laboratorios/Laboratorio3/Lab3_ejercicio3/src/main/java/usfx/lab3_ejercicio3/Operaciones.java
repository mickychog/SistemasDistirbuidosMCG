/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.lab3_ejercicio3;

/**
 *
 * @author micky
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Operaciones extends UnicastRemoteObject implements IOperaciones{
    private int a;
    private int b;

    public Operaciones() throws RemoteException {
        super();
    }

    @Override
    public void anotar(int a, int b) throws RemoteException {
        this.a = a;
        this.b = b;
    }

    @Override
    public int suma() throws RemoteException {
        return a + b;
    }

    @Override
    public int restar() throws RemoteException {
        return a - b;
    }
}

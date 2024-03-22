/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.lab3_ejercicio3;

/**
 *
 * @author micky
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperaciones extends Remote {
    void anotar(int a, int b) throws RemoteException;
    int suma() throws RemoteException;
    int restar() throws RemoteException;
}

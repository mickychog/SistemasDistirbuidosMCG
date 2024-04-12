/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.pagosruat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Saludo extends UnicastRemoteObject implements IRuat {
  
    public Saludo() throws RemoteException
    {
        super();
    }
    
    @Override
    public String HolaMundo() throws RemoteException {
        return "Hola Mundo en SIS258 con RMI";
    }

    @Override
    public Deuda[] buscar(int ci) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean pagar(Deuda deuda) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
}

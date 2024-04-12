/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package usfx.pagosruat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRuat extends Remote {
    Deuda[] buscar(int ci) throws RemoteException;
    boolean pagar(Deuda deuda) throws RemoteException;
    public String HolaMundo() throws RemoteException;
}

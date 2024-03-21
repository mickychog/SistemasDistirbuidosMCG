/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package usfx.laboratorio3_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IEmpresa extends Remote{
    public Factura[] pendientes(int idcliente)throws RemoteException;
    public String pagar(Factura[] facturas)throws RemoteException;

    
    
}

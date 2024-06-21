/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reservahotel;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IServidorReserva extends Remote {

    public double Cotizar(String _inicio, String _fin, String _fechaCotizacion) throws RemoteException;

    public String Reservar(String _inicio, String _fin, String _idcliente, String _fechaCompra) throws RemoteException;
}

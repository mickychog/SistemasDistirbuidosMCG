/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.pagosruat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ServidorRuat extends UnicastRemoteObject implements IRuat {
    
    

    private List<Deuda> deudas;

    public ServidorRuat() throws RemoteException {
        super();
        this.deudas = new ArrayList<>();
        this.deudas.add(new Deuda(1234567, 2022, "Vehículo", 2451));
        this.deudas.add(new Deuda(1234567, 2022, "Casa", 2500));
        this.deudas.add(new Deuda(555587, 2021, "Vehículo", 5000));
        this.deudas.add(new Deuda(333357, 2023, "Casa", 24547));
    }

    @Override
    public Deuda[] buscar(int ci) throws RemoteException {
        List<Deuda> deudasEncontradas = new ArrayList<>();
        for (Deuda deuda : deudas) {
            if (Integer.parseInt(deuda.getCi()) == ci) {
                deudasEncontradas.add(deuda);
            }
        }
        return deudasEncontradas.toArray(new Deuda[0]);
    }

    @Override
    public boolean pagar(Deuda deuda) throws RemoteException {
        for (Deuda d : deudas) {
            if (d.equals(deuda)) {        
                d.setPagada(true);
                return true;
            }
        }
        return false; 
    }

    @Override
    public String HolaMundo() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
}

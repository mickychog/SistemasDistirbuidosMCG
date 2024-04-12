/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usfx.pagosruat;

import java.io.Serializable;

/**
 *
 * @author micky
 */


public class Deuda implements Serializable {
    private String ci;
    private int anio;
    private String impuesto;
    private double monto;
    
    
    public Deuda(String ci, int anio, String impuesto) {
        this.ci = ci;
        this.anio = anio;
        this.impuesto = impuesto;
    }

    Deuda(int i, int i0, String vehículo, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getCi() {
        return ci;
    }

    public int getAnio() {
        return anio;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public double getMonto() {
        return monto;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    void setPagada(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}


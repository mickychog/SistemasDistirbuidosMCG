/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservahotel;

import java.math.BigDecimal;


public class CotizacionFechas {

    private String fecha;
    private BigDecimal precio;

    CotizacionFechas(String _fecha, BigDecimal _precio) {
        this.fecha = _fecha;
        this.precio = _precio;
    }

    public String getfecha() {
        return fecha;
    }

    public BigDecimal getprecio() {
        return precio;
    }

    @Override
    public String toString() {
        return fecha + " cuesta " + precio + " $us";
    }
}

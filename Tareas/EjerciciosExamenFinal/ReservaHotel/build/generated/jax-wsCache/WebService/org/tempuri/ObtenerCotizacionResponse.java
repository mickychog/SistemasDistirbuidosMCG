
package org.tempuri;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ObtenerCotizacionResult" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "obtenerCotizacionResult"
})
@XmlRootElement(name = "ObtenerCotizacionResponse")
public class ObtenerCotizacionResponse {

    @XmlElement(name = "ObtenerCotizacionResult", required = true)
    protected BigDecimal obtenerCotizacionResult;

    /**
     * Obtiene el valor de la propiedad obtenerCotizacionResult.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getObtenerCotizacionResult() {
        return obtenerCotizacionResult;
    }

    /**
     * Define el valor de la propiedad obtenerCotizacionResult.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setObtenerCotizacionResult(BigDecimal value) {
        this.obtenerCotizacionResult = value;
    }

}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de Oper
/// </summary>
public class Oper
{

        //
        // TODO: Agregar aquí la lógica del constructor
        //
    public DateTime inicio { get; set; }
    public DateTime fin { get; set; }
    public DateTime fechacotizacion { get; set; }

    public int idcliente { get; set; }
    public DateTime FechaCompra { get; set; }

    public override string ToString()
    {
        return $"Fecha inicio: {inicio}, Fecha fin: {fin}, Fechacotizacion: {fechacotizacion}";
    }

}
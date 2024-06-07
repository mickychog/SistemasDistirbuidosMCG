using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de WebService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class WebService : System.Web.Services.WebService
{

    public WebService()
    {

        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }


    [WebMethod]
    public Oper Cotizar(DateTime inicio, DateTime fin)
    {
        // Aquí debes implementar la lógica para obtener los datos de la persona
        // basándote en la cédula de identidad proporcionada.
        // Por ahora, devolveré una persona de prueba.
        return new Oper
        {
            inicio = inicio,
            fin = fin,
            fechacotizacion = DateTime.Parse("2050-01-01"),
        };
    }

    [WebMethod]
    public Oper Reservar(DateTime inicio, DateTime fin)
    {
        // Aquí debes implementar la lógica para obtener el certificado de nacimiento
        // de la persona basándote en la cédula de identidad proporcionada.
        // Por ahora, devolveré un certificado de nacimiento de prueba.
        return new Oper
        {
            inicio = inicio,
            fin=fin,
            fechacotizacion = DateTime.Parse("1990-01-01"),
        };
    }

}

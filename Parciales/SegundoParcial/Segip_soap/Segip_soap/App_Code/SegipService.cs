using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de SegipService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class SegipService : System.Web.Services.WebService
{

    public SegipService()
    {

        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }

    [WebMethod]
    public bool VerificarDatos(string ci, string nombres, string primerApellido, string segundoApellido)
    {


        string ejemploCI = "1234567";
        string ejemploNombres = "Juan";
        string ejemploPrimerApellido = "Perez";
        string ejemploSegundoApellido = "Gomez";


        bool ciCoincide = ci == ejemploCI;
        bool nombresCoinciden = nombres == ejemploNombres;
        bool primerApellidoCoincide = primerApellido == ejemploPrimerApellido;
        bool segundoApellidoCoincide = segundoApellido == ejemploSegundoApellido;

        
        return ciCoincide && nombresCoinciden && primerApellidoCoincide && segundoApellidoCoincide;
    }

    [WebMethod]
    public (string CI, string nombres, string primerApellido, string segundoApellido) obtenerDatos()
    {
        string ejemploCI = "1234567";
        string ejemploNombres = "Juan";
        string ejemploPrimerApellido = "Perez";
        string ejemploSegundoApellido = "Gomez";

        return (ejemploCI, ejemploNombres, ejemploPrimerApellido, ejemploSegundoApellido);
    }

}
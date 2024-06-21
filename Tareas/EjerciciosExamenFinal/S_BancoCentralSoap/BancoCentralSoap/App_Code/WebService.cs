using MySql.Data.MySqlClient;
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

    private string connectionString = "Server=localhost;Database=bd_cotizacion_soap;Uid=root;Pwd='';";

 
    [WebMethod]
    public decimal ObtenerCotizacion(string fecha)
    {
        string query = "SELECT Cotizacion FROM Cotizaciones WHERE Fecha = @fecha";
        using (MySqlConnection conn = new MySqlConnection(connectionString))
        {
            MySqlCommand cmd = new MySqlCommand(query, conn);
            cmd.Parameters.AddWithValue("@fecha", fecha);

            conn.Open();
            object result = cmd.ExecuteScalar();

            if (result != null)
            {
                return Convert.ToDecimal(result);
            }
            else
            {
                return 6.97m;
            }
        }
    }


}

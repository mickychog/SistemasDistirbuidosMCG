using System;
using System.Web.Services;

/// <summary>
/// Descripción breve de ServicioSereci
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
[System.ComponentModel.ToolboxItem(false)]
public class ServicioSereci : System.Web.Services.WebService
{
    
    private const string CarnetValido = "123456";
    private const string CarnetValido2 = "654321";

    [WebMethod]
    public Persona ObtenerDatos(string CI)
    {
        if (CI == CarnetValido)
        {
            return new Persona
            {
                Carnet = "123456",
                Nombres = "Juan",
                PrimerApellido = "Perez",
                SegundoApellido = "Soza",
                FechaNacimiento = "1992-07-09",
                Sexo = "Masculino",
                EstadoCivil = "Soltero"
            };
        }
        else
        {
            return new Persona
            {
                Carnet = "Carnet no encontrado"
            };
        }
    }

    [WebMethod]
    public Persona ObtenerCertificadoNacimiento(string CI)
    {
        if (CI == CarnetValido2)
        {
            return new Persona
            {
                Carnet = "654321",
                Nombres = "Maria",
                PrimerApellido = "Gonzalez",
                SegundoApellido = "Lopez",
                FechaNacimiento = "1985-08-20",
                DatosPadre = "Pedro Gonzalez",
                DatosMadre = "Ana Lopez"
            };
        }
        else
        {
            return new Persona
            {
                Nombres = "Carnet no encontrado"
            };
        }
    }
}

public class Persona
{
    public string Carnet { get; set; }
    public string Nombres { get; set; }
    public string PrimerApellido { get; set; }
    public string SegundoApellido { get; set; }
    public string FechaNacimiento { get; set; }
    public string Sexo { get; set; }
    public string EstadoCivil { get; set; }
    public string DatosPadre { get; set; }
    public string DatosMadre { get; set; }
}

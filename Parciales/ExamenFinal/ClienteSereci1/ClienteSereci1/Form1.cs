using System;
using System.Windows.Forms;

namespace ClienteSereci
{
    public partial class Form1 : Form
    {
        private ServiceReference1.ServicioSereciSoapClient servicio;

        public Form1()
        {
            InitializeComponent();
            servicio = new ServiceReference1.ServicioSereciSoapClient(ServiceReference1.ServicioSereciSoapClient.EndpointConfiguration.ServicioSereciSoap);
        }

        private async void btnObtenerDatos_Click(object sender, EventArgs e)
        {
            string ci = txtCI.Text.Trim();
            var response = await servicio.ObtenerDatosAsync(ci);

            if (response.Body != null && response.Body.ObtenerDatosResult != null)
            {
                MostrarDatosPersona(response.Body.ObtenerDatosResult);
            }
            else
            {
                MessageBox.Show("No se encontraron datos para la CI proporcionada.");
            }
        }


        private async void btnObtenerCertificado_Click(object sender, EventArgs e)
        {
            string ci = txtCI.Text.Trim();
            var response = await servicio.ObtenerCertificadoNacimientoAsync(ci);

            if (response.Body != null && response.Body.ObtenerCertificadoNacimientoResult != null)
            {
                MostrarDatosCertificado(response.Body.ObtenerCertificadoNacimientoResult);
            }
            else
            {
                MessageBox.Show("No se encontraron datos para la CI proporcionada.");
            }
        }


        private void MostrarDatosPersona(ServiceReference1.Persona persona)
        {
            dataGridView.Rows.Clear();
            dataGridView.Columns.Clear();

            dataGridView.Columns.Add("Campo", "Campo");
            dataGridView.Columns.Add("Valor", "Valor");

            dataGridView.Rows.Add("Carnet", persona.Carnet);
            dataGridView.Rows.Add("Nombres", persona.Nombres);
            dataGridView.Rows.Add("Primer Apellido", persona.PrimerApellido);
            dataGridView.Rows.Add("Segundo Apellido", persona.SegundoApellido);
            dataGridView.Rows.Add("Fecha de Nacimiento", persona.FechaNacimiento);
            dataGridView.Rows.Add("Sexo", persona.Sexo);
            dataGridView.Rows.Add("Estado Civil", persona.EstadoCivil);
        }

        private void MostrarDatosCertificado(ServiceReference1.Persona persona)
        {
            dataGridView.Rows.Clear();
            dataGridView.Columns.Clear();

            dataGridView.Columns.Add("Campo", "Campo");
            dataGridView.Columns.Add("Valor", "Valor");

            dataGridView.Rows.Add("Nombres", persona.Nombres);
            dataGridView.Rows.Add("Primer Apellido", persona.PrimerApellido);
            dataGridView.Rows.Add("Segundo Apellido", persona.SegundoApellido);
            dataGridView.Rows.Add("Fecha de Nacimiento", persona.FechaNacimiento);
            dataGridView.Rows.Add("Datos Padre", persona.DatosPadre);
            dataGridView.Rows.Add("Datos Madre", persona.DatosMadre);
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void txtCI_TextChanged(object sender, EventArgs e)
        {

        }
    }
}

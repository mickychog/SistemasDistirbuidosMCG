using Datos;

namespace Lab_5_ConsumirServicio
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String ci = txtci.Text;
            Datos.WebServiceSoapClient cliente = new Datos.WebServiceSoapClient(new Datos.WebServiceSoapClient.EndpointConfiguration());
            // Suponiendo que tu servicio web tiene un método llamado 'Sumar'
            // Declarar 'c' como una variable del tipo 'Persona'
            Persona c = null;
            switch (cmbboxop.SelectedIndex)
            {
                case 0:
                    c = cliente.ObtenerDatos(ci);
                    break;
                case 1:
                    c = cliente.ObtenerCertificadoNacimiento(ci);
                    break;
                case 2:
                    c = cliente.ObtenerCertificadoMatrimonio(ci);
                    break;
                case 3:
                    c = cliente.ObtenerCertificadoDefuncion(ci);
                    break;
            }
            // Verificar si 'c' es 'null' antes de usarla
            if (c != null)
            {
                resp.Text = c.ToString();
            }
            else
            {
                resp.Text = "No se pudo obtener la información.";
            }
        }

        private void txtci_TextChanged(object sender, EventArgs e)
        {

        }
    }
}

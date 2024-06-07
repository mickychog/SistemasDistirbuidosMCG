using Newtonsoft.Json;
using GraphQL;
using GraphQL.Client.Http;
using GraphQL.Client.Serializer.Newtonsoft;


namespace ClienteReserva
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void dateTimePicker1_ValueChanged(object sender, EventArgs e)
        {

        }

        private void datefin_ValueChanged(object sender, EventArgs e)
        {

        }

        private void btncotizar_Click(object sender, EventArgs e)
        {

        }

        private void btnreservar_Click(object sender, EventArgs e)
        {

        }

        private void respuesta_Click(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private async void btnverificar_Click(object sender, EventArgs e)
        {
            string url = "http://localhost:4000/graphql";
            string query = @"
                {
                    bancocentral {
                        fecha
                        cotizacion
                    }
                }";

            var bancoc = await GetDataFromApiAsync(url, query);
            
     
            respuesta.Text = bancoc;

            
        }
        public static async Task<bancocentral> GetDataFromApiAsync(string url, string query)
        {
            var client = new GraphQLHttpClient(url, new NewtonsoftJsonSerializer());
            var request = new GraphQLRequest
            {
                Query = query
            };

            var response = await client.SendQueryAsync<bancocentral>(request);
            return response.Data;
        }
        public class ResponseType
        {
            public bancocentral bancocentral { get; set; }

        }
    }
}

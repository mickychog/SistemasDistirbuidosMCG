using System;
using System.Windows.Forms;
using RestSharp;
using GraphQL.Client.Http;
using GraphQL.Client.Serializer.Newtonsoft;
using System.Threading.Tasks;
using System.Collections.Generic;
using System.Data;
using GraphQL;

namespace appfinal
{
    public partial class Form1 : Form
    {
        private const string REST_API_URL = "http://localhost:8000/api/pronosticos";
        private const string GRAPHQL_API_URL = "http://localhost:4000/graphql";

        public Form1()
        {
            InitializeComponent();
        }

        private async void button1_Click(object sender, EventArgs e)
        {
            string serviceType = cmbServiceType.SelectedItem?.ToString();
            if (serviceType == "REST")
            {
                await RestApi();
            }
            else if (serviceType == "GraphQL")
            {
                await GraphQLApi();
            }
        }

        private void lblTitle_Click(object sender, EventArgs e)
        {
            
        }

        private async Task RestApi()
        {
            var client = new RestClient(REST_API_URL);
            var request = new RestRequest("", Method.Get);
            var response = await client.ExecuteAsync<List<Pronostico>>(request);

            if (response.IsSuccessful)
            {
                DisplayData(response.Data);
            }
            else
            {
                MessageBox.Show("Error ");
            }
        }

        private async Task GraphQLApi()
        {
            var client = new GraphQLHttpClient(GRAPHQL_API_URL, new NewtonsoftJsonSerializer());
            var request = new GraphQLRequest
            {
                Query = @"
                {
                    pronosticos {
                        id
                        fecha
                        temperatura
                 }
                }"
            };

            var response = await client.SendQueryAsync<ResponseType>(request);

            if (response.Errors == null)
            {
                DisplayData(response.Data.Pronosticos);
            }
            else
            {
                MessageBox.Show("Error");
            }
        }

        private void DisplayData(List<Pronostico> pronosticos)
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("ID");
            dt.Columns.Add("Fecha");
            dt.Columns.Add("Temperatura");

            foreach (var pronostico in pronosticos)
            {
                dt.Rows.Add(pronostico.Id, pronostico.Fecha, pronostico.Temperatura);
            }

            dataGridViewResults.DataSource = dt;
        }
    }

    public class Pronostico
    {
        public int Id { get; set; }
        public string Fecha { get; set; } = string.Empty; // Inicializado para evitar nulos
        public int Temperatura { get; set; }
    }

    public class ResponseType
    {
        public List<Pronostico> Pronosticos { get; set; } = new List<Pronostico>(); // Inicializado para evitar nulos
    }
}

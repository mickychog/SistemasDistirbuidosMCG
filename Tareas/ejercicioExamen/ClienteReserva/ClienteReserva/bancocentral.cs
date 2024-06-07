using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClienteReserva
{
    public class bancocentral
    {
        public int id { get; set; }
        public DateTime fecha { get; set; }
        public float cotizacion { get; set; }

        public override string ToString()
        {
            return $"ID: {id}, Fecha: {fecha}, Cotización: {cotizacion}";
        }

    }

    
}

# instalar dependencia
mkdir graphql-mysql
cd graphql-mysql
npm init -y
npm install express graphql express-graphql mysql2 sequelize
node server.js 
#consultas

consultar
{
  pronosticos {
    id
    fecha
    temperatura
  }
}
consultar uno
{
  pronostico(id: 1) {
    id
    fecha
    temperatura
  }
}


crear
mutation {
  addPronostico(fecha: "2024-06-21", temperatura: 28) {
    id
    fecha
    temperatura
  }
}

actualizar
mutation {
  updatePronostico(id: 2, fecha: "2024-06-22", temperatura: 22) {
    id
    fecha
    temperatura
  }
}

eliminar
mutation {
  deletePronostico(id: 1) {
    id
    fecha
    temperatura
  }
}

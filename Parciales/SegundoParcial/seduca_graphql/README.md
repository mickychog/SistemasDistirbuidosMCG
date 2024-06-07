# instalar dependencia
mkdir graphql-mysql
cd graphql-mysql
npm init -y
npm install express graphql express-graphql mysql2 sequelize
node server.js 
#consultas 

mutation {
  addCalificacion(ci: "123456", apellidos: "Perez", nombres: "Juan", esBachiller: true) {
    ci
    apellidos
    nombres
    esBachiller
  }
}

{
  calificaciones {
    ci
    apellidos
    nombres
    esBachiller
  }
}


{
  calificacion(ci: "123456") {
    ci
    apellidos
    nombres
    esBachiller
  }
}

mutation {
  updateCalificacion(ci: "123456", apellidos: "Perez", nombres: "Juan Carlos") {
    ci
    apellidos
    nombres
    esBachiller
  }
}

mutation {
  deleteCalificacion(ci: "123456") {
    ci
  }
}

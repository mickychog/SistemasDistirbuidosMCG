const { gql } = require('apollo-server-express');

const typeDefs = gql`
  type Libro {
    id: ID!
    titulo: String!
    autor: String!
    disponible: Boolean!
  }

  type Lector {
    id: ID!
    nombre: String!
    libroPrestado: ID
  }

  type Query {
    libros: [Libro]
    libro(id: ID!): Libro
    lectores: [Lector]
    lector(id: ID!): Lector
  }

  type Mutation {
    agregarLibro(titulo: String!, autor: String!): Libro
    agregarLector(nombre: String!): Lector
    prestarLibro(idLector: ID!, idLibro: ID!): Lector
    devolverLibro(idLector: ID!, idLibro: ID!): Lector
  }
`;

module.exports = typeDefs;

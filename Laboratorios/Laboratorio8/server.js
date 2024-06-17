const express = require('express');
const { ApolloServer } = require('apollo-server-express');
const { sequelize } = require('./database');
const typeDefs = require('./schema');
const resolvers = require('./resolvers'); // Crearemos un archivo resolvers.js

const app = express();

const server = new ApolloServer({ typeDefs, resolvers });

server.start().then(() => {
  server.applyMiddleware({ app });

  sequelize.authenticate()
    .then(() => {
      console.log('Connection to the database has been established successfully.');
      app.listen({ port: 4000 }, () => {
        console.log(`Server is running on http://localhost:4000${server.graphqlPath}`);
      });
    })
    .catch(err => {
      console.error('Unable to connect to the database:', err);
    });
});

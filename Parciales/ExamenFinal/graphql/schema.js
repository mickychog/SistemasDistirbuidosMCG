// schema.js
const { GraphQLObjectType, GraphQLString, GraphQLInt, GraphQLSchema, GraphQLList, GraphQLNonNull } = require('graphql');
const { Pronostico } = require('./database');

const PronosticoType = new GraphQLObjectType({
  name: 'Pronostico',
  fields: {
    id: { type: GraphQLInt },
    fecha: { type: GraphQLString },
    temperatura: { type: GraphQLInt }
  }
});

const RootQuery = new GraphQLObjectType({
  name: 'RootQueryType',
  fields: {
    pronosticos: {
      type: new GraphQLList(PronosticoType),
      resolve() {
        return Pronostico.findAll();
      }
    },
    pronostico: {
      type: PronosticoType,
      args: { id: { type: GraphQLInt } },
      resolve(_, args) {
        return Pronostico.findByPk(args.id);
      }
    }
  }
});

const Mutation = new GraphQLObjectType({
  name: 'Mutation',
  fields: {
    addPronostico: {
      type: PronosticoType,
      args: {
        fecha: { type: new GraphQLNonNull(GraphQLString) },
        temperatura: { type: new GraphQLNonNull(GraphQLInt) }
      },
      resolve(_, args) {
        return Pronostico.create({
          fecha: args.fecha,
          temperatura: args.temperatura
        });
      }
    },
    updatePronostico: {
      type: PronosticoType,
      args: {
        id: { type: new GraphQLNonNull(GraphQLInt) },
        fecha: { type: GraphQLString },
        temperatura: { type: GraphQLInt }
      },
      resolve(_, args) {
        return Pronostico.findByPk(args.id)
          .then(pronostico => {
            if (!pronostico) throw new Error('Pronostico no encontrado');
            return pronostico.update({
              fecha: args.fecha !== undefined ? args.fecha : pronostico.fecha,
              temperatura: args.temperatura !== undefined ? args.temperatura : pronostico.temperatura
            });
          });
      }
    },
    deletePronostico: {
      type: PronosticoType,
      args: {
        id: { type: new GraphQLNonNull(GraphQLInt) }
      },
      resolve(_, args) {
        return Pronostico.findByPk(args.id)
          .then(pronostico => {
            if (!pronostico) throw new Error('Pronostico no encontrado');
            return pronostico.destroy();
          });
      }
    }
  }
});

module.exports = new GraphQLSchema({
  query: RootQuery,
  mutation: Mutation
});

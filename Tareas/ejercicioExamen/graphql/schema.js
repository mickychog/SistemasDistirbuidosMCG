const { GraphQLObjectType, GraphQLString, GraphQLFloat, GraphQLSchema, GraphQLList, GraphQLNonNull } = require('graphql');
const { Cotizacion } = require('./database');

const CotizacionType = new GraphQLObjectType({
  name: 'cotizacion',
  fields: {
    fecha: { type: GraphQLString },
    cotizacion: { type: GraphQLFloat }
  }
});

const RootQuery = new GraphQLObjectType({
  name: 'RootQueryType',
  fields: {
    cotizaciones: {
      type: new GraphQLList(CotizacionType),
      resolve() {
        return Cotizacion.findAll();
      }
    },
    cotizacion: {
      type: CotizacionType,
      args: { fecha: { type: GraphQLString } },
      resolve(parent, args) {
        return Cotizacion.findOne({ where: { fecha: args.fecha } });
      }
    }
  }
});

const Mutation = new GraphQLObjectType({
  name: 'Mutation',
  fields: {
    addCotizacion: {
      type: CotizacionType,
      args: {
        fecha: { type: new GraphQLNonNull(GraphQLString) },
        cotizacion: { type: new GraphQLNonNull(GraphQLFloat) }
      },
      resolve(parent, args) {
        return Cotizacion.create({
          fecha: args.fecha,
          cotizacion: args.cotizacion
        });
      }
    },
    updateCotizacion: {
      type: CotizacionType,
      args: {
        fecha: { type: new GraphQLNonNull(GraphQLString) },
        cotizacion: { type: GraphQLFloat }
      },
      resolve(parent, args) {
        return Cotizacion.findByPk(args.fecha)
          .then(cotizacion => {
            if (!cotizacion) {
              throw new Error('Cotizacion no encontrada');
            }
            return cotizacion.update({
              cotizacion: args.cotizacion !== undefined ? args.cotizacion : cotizacion.cotizacion
            });
          });
      }
    }
  }
});

module.exports = new GraphQLSchema({
  query: RootQuery,
  mutation: Mutation
});

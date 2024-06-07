const { GraphQLObjectType, GraphQLString, GraphQLBoolean, GraphQLSchema, GraphQLList, GraphQLNonNull } = require('graphql');
const { Calificaciones } = require('./database');

const CalificacionesType = new GraphQLObjectType({
  name: 'Calificaciones',
  fields: {
    ci: { type: GraphQLString },
    apellidos: { type: GraphQLString },
    nombres: { type: GraphQLString },
    esBachiller: { type: GraphQLBoolean }
  }
});

const RootQuery = new GraphQLObjectType({
  name: 'RootQueryType',
  fields: {
    calificaciones: {
      type: new GraphQLList(CalificacionesType),
      resolve(parent, args) {
        return Calificaciones.findAll();
      }
    },
    calificacion: {
      type: CalificacionesType,
      args: { ci: { type: GraphQLString } },
      resolve(parent, args) {
        return Calificaciones.findByPk(args.ci);
      }
    }
  }
});

const Mutation = new GraphQLObjectType({
  name: 'Mutation',
  fields: {
    addCalificacion: {
      type: CalificacionesType,
      args: {
        ci: { type: new GraphQLNonNull(GraphQLString) },
        apellidos: { type: new GraphQLNonNull(GraphQLString) },
        nombres: { type: new GraphQLNonNull(GraphQLString) },
        esBachiller: { type: new GraphQLNonNull(GraphQLBoolean) }
      },
      resolve(parent, args) {
        return Calificaciones.create({
          ci: args.ci,
          apellidos: args.apellidos,
          nombres: args.nombres,
          esBachiller: args.esBachiller
        });
      }
    },
    updateCalificacion: {
      type: CalificacionesType,
      args: {
        ci: { type: new GraphQLNonNull(GraphQLString) },
        apellidos: { type: GraphQLString },
        nombres: { type: GraphQLString },
        esBachiller: { type: GraphQLBoolean }
      },
      resolve(parent, args) {
        return Calificaciones.findByPk(args.ci)
          .then(calificacion => {
            if (!calificacion) {
              throw new Error('Calificacion no encontrada');
            }
            return calificacion.update({
              apellidos: args.apellidos !== undefined ? args.apellidos : calificacion.apellidos,
              nombres: args.nombres !== undefined ? args.nombres : calificacion.nombres,
              esBachiller: args.esBachiller !== undefined ? args.esBachiller : calificacion.esBachiller
            });
          });
      }
    },
    deleteCalificacion: {
      type: CalificacionesType,
      args: {
        ci: { type: new GraphQLNonNull(GraphQLString) }
      },
      resolve(parent, args) {
        return Calificaciones.findByPk(args.ci)
          .then(calificacion => {
            if (!calificacion) {
              throw new Error('Calificacion no encontrada');
            }
            return calificacion.destroy();
          });
      }
    }
  }
});

module.exports = new GraphQLSchema({
  query: RootQuery,
  mutation: Mutation
});

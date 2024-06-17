const { Libro, Lector } = require('./database');

const resolvers = {
  Query: {
    libros: () => Libro.findAll(),
    libro: (parent, { id }) => Libro.findByPk(id),
    lectores: () => Lector.findAll(),
    lector: (parent, { id }) => Lector.findByPk(id),
  },
  Mutation: {
    agregarLibro: (parent, { titulo, autor }) => {
      return Libro.create({
        titulo,
        autor,
        disponible: true,
      });
    },
    agregarLector: (parent, { nombre }) => {
      return Lector.create({
        nombre,
        libroPrestado: null,
      });
    },
    prestarLibro: async (parent, { idLector, idLibro }) => {
      const libro = await Libro.findByPk(idLibro);
      if (!libro || !libro.disponible) {
        throw new Error('Libro no disponible');
      }
      const lector = await Lector.findByPk(idLector);
      if (!lector) {
        throw new Error('Lector no encontrado');
      }
      await libro.update({ disponible: false });
      return lector.update({ libroPrestado: idLibro });
    },
    devolverLibro: async (parent, { idLector, idLibro }) => {
      const libro = await Libro.findByPk(idLibro);
      if (!libro || libro.disponible) {
        throw new Error('Libro no está prestado');
      }
      const lector = await Lector.findByPk(idLector);
      if (!lector || lector.libroPrestado !== idLibro) {
        throw new Error('Lector no ha prestado este libro');
      }
      await libro.update({ disponible: true });
      return lector.update({ libroPrestado: null });
    },
  },
};

module.exports = resolvers;

const { Sequelize } = require('sequelize');

const sequelize = new Sequelize('ex_seduca', 'root', '', {
  host: 'localhost',
  dialect: 'mysql'
});

const Calificaciones = sequelize.define('Calificaciones', {
  ci: {
    type: Sequelize.STRING,
    allowNull: false,
    primaryKey: true
  },
  apellidos: {
    type: Sequelize.STRING,
    allowNull: false
  },
  nombres: {
    type: Sequelize.STRING,
    allowNull: false
  },
  esBachiller: {
    type: Sequelize.BOOLEAN,
    allowNull: false
  }
}, {
  tableName: 'calificaciones',
  timestamps: false
});

sequelize.sync();

module.exports = { sequelize, Calificaciones };
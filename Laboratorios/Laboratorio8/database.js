const { Sequelize, DataTypes } = require('sequelize');

const sequelize = new Sequelize('biblioteca_g_bd', 'root', '', {
  host: 'localhost',
  dialect: 'mysql'
});

const Libro = sequelize.define('libro', {
  id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true
  },
  titulo: {
    type: DataTypes.STRING,
    allowNull: false
  },
  autor: {
    type: DataTypes.STRING,
    allowNull: false
  },
  disponible: {
    type: DataTypes.BOOLEAN,
    defaultValue: true
  }
}, {
  tableName: 'libro',
  timestamps: false
});

const Lector = sequelize.define('lector', {
  id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true
  },
  nombre: {
    type: DataTypes.STRING,
    allowNull: false
  },
  libroPrestado: {
    type: DataTypes.INTEGER,
    allowNull: true
  }
}, {
  tableName: 'lector',
  timestamps: false
});

sequelize.sync();

module.exports = { sequelize, Libro, Lector };

const { Sequelize, DataTypes } = require('sequelize');

const sequelize = new Sequelize('banco_cliente_bd', 'root', '', {
  host: 'localhost',
  dialect: 'mysql'
});

const Cotizacion = sequelize.define('cotizacion', {
    id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true
      },
    fecha: {
        type: DataTypes.DATEONLY,
        allowNull: false,
    },
    cotizacion: {
        type: DataTypes.FLOAT,
        allowNull: false
    }
}, {
  tableName: 'cotizacion',
  timestamps: false
});

sequelize.sync();

module.exports = { sequelize, Cotizacion };

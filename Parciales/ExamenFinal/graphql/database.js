// db.js
const { Sequelize, DataTypes } = require('sequelize');
const sequelize = new Sequelize('bd_clima', 'root', '', {
    host: 'localhost',
    dialect: 'mysql'
});

const Pronostico = sequelize.define('Pronostico', {
    id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    fecha: {
        type: DataTypes.DATE,
        allowNull: false
    },
    temperatura: {
        type: DataTypes.INTEGER,
        allowNull: false
    }
}, {
    tableName: 'pronosticos',
    timestamps: false
});

module.exports = { sequelize, Pronostico };

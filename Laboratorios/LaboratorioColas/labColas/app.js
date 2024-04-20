const express = require('express');
const mysql = require('mysql');
const app = express();
const PORT = 3000;
const sendToQueue = require('./cola-correo'); // Importar la función sendToQueue desde cola-correo.js

// Configuración de la conexión a la base de datos MySQL
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root', // Cambia esto si tu usuario de MySQL es diferente
    password: '', // Cambia esto si has configurado una contraseña para tu usuario de MySQL
    database: 'bd_ccbol'
});

// Conectar a la base de datos MySQL
db.connect((err) => {
    if (err) {
        throw err;
    }
    console.log('Conectado a la base de datos MySQL');
});

// Configurar Express.js
app.use(express.urlencoded({ extended: true }));
app.use(express.static('public'));

// Ruta para mostrar el formulario HTML
app.get('/', (req, res) => {
    res.sendFile(__dirname + '/public/formulario.html');
});

// Ruta para manejar la inscripción de participantes
app.post('/inscripcion', (req, res) => {
    const participante = req.body;

    // Insertar los datos del participante en la base de datos
    db.query('INSERT INTO participantes SET ?', participante, (err, result) => {
        if (err) {
            throw err;
        }
        console.log('Participante registrado en la base de datos');
    });

    // Enviar los datos del participante a la cola de mensajes
    sendToQueue(participante);

    res.send('¡Gracias por inscribirte a la CCBOL 2024!');
});

// Iniciar el servidor Express.js
app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});

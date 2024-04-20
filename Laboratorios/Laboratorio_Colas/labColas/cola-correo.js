const amqp = require('amqplib/callback_api');
const nodemailer = require('nodemailer');

const correos = []; 

// Configurar el transportador de correo electrónico
const transporter = nodemailer.createTransport({
    service: 'Gmail',
    auth: {
        user: 'choque.garcia.miguelangel@usfx.bo', // dirección de correo
        pass: '1234567890abcd' // contraseña
    }
});

// Conectar a RabbitMQ y configurar la cola
amqp.connect('amqp://localhost', (error, connection) => {
    if (error) {
        throw error;
    }

    connection.createChannel((error, channel) => {
        if (error) {
            throw error;
        }

        const queue = 'cola-correo';

        channel.assertQueue(queue, {
            durable: true
        });

        console.log(" [*] Esperando mensajes en %s. Para salir, presiona CTRL+C", queue);
        channel.consume(queue, (msg) => {
            console.log(" [x] Recibido %s", msg.content.toString());

            // Agregar el mensaje a la lista de correos
            const correo = JSON.parse(msg.content.toString());
            correos.push(correo);

                       // Si hay suficientes correos en la lista, enviarlos
            if (correos.length >= 10) {
                enviarCorreos();
            }
        }, {
            noAck: false
        });

        // Función para enviar correos
        const enviarCorreos = () => {
            
            const correosParaEnviar = correos.slice(0, 10);

            // Construir el cuerpo del correo
            const cuerpoCorreo = correosParaEnviar.map(correo => {
                
                return {
                    from: 'choque.garcia.miguelangel@usfx.bo',
                    to: correo.email,
                    subject: 'Inscripcion a la CCBOL',
                    text: 'Bienvenido a  la CCBOL 2024 su inscripcion a sido completada con exito, FELIDIDADES..!!!'
                };
            });
            //console.log("Cuerpo del correo:", cuerpoCorreo);

            // Enviar los correos
            transporter.sendMail(cuerpoCorreo, (error, info) => {
                if (error) {
                    console.log("Error al enviar correos:", error);
                } else {
                    console.log("Correos enviados:", info.response);
                    // Eliminar los correos enviados de la lista
                    correos.splice(0, correosParaEnviar.length);

                    // Confirmar la recepción de los mensajes
                    correosParaEnviar.forEach(correo => {
                        channel.ack(correo);
                    });

                    console.log(" [x] Correos enviados y mensajes confirmados");
                }
            });
        };
    });
});

// Exportar la función sendToQueue para su uso en otros archivos
module.exports = function sendToQueue(data) {
    amqp.connect('amqp://localhost', (error, connection) => {
        if (error) {
            throw error;
        }

        connection.createChannel((error, channel) => {
            if (error) {
                throw error;
            }

            const queue = 'cola-correo';
            const message = JSON.stringify(data);

            channel.assertQueue(queue, {
                durable: true
            });

            channel.sendToQueue(queue, Buffer.from(message), {
                persistent: true
            });

            console.log(" [x] Enviado %s", message);
        });
    });
};

<?php

// Incluye el archivo autoload.php de Composer para cargar las clases de PhpAmqpLib
require_once __DIR__ . '/vendor/autoload.php';

// Importa las clases necesarias de PhpAmqpLib
use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;

// Establece una conexión con el servidor RabbitMQ
$connection = new AMQPStreamConnection('localhost', 5672, 'guest', 'guest');

// Crea un canal de comunicación con RabbitMQ
$channel = $connection->channel();

// Declara un intercambio (exchange) en RabbitMQ llamado 'logs' con el tipo 'fanout'
$channel->exchange_declare('logs', 'fanout', false, false, false);

// Obtiene los argumentos pasados por la línea de comandos
$data = implode(' ', array_slice($argv, 1));

// Si no se proporcionan argumentos en la línea de comandos, establece un mensaje predeterminado
if (empty($data)) {
    $data = "info: Hello World!";
}

// Crea un mensaje AMQP con el contenido especificado
$msg = new AMQPMessage($data);

// Publica el mensaje en el intercambio 'logs'
$channel->basic_publish($msg, 'logs');

// Imprime un mensaje indicando que el mensaje se ha enviado correctamente
echo ' [x] Sent ', $data, "\n";

// Cierra el canal de comunicación
$channel->close();

// Cierra la conexión con el servidor RabbitMQ
$connection->close();

?>

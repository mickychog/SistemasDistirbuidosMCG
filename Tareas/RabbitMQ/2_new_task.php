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

// Declara una cola en RabbitMQ llamada 'task_queue'
$channel->queue_declare('task_queue', false, true, false, false);

// Obtiene los argumentos pasados por la línea de comandos
$data = implode(' ', array_slice($argv, 1));

// Si no se proporcionan argumentos en la línea de comandos, establece un mensaje predeterminado
if (empty($data)) {
    $data = "Hello World!";
}

// Crea un mensaje AMQP con el contenido especificado
$msg = new AMQPMessage(
    $data,
    array('delivery_mode' => AMQPMessage::DELIVERY_MODE_PERSISTENT) // Establece el modo de entrega como persistente
);

// Publica el mensaje en la cola 'task_queue'
$channel->basic_publish($msg, '', 'task_queue');

// Imprime un mensaje indicando que el mensaje se ha enviado correctamente
echo ' [x] Sent ', $data, "\n";

// Cierra el canal de comunicación
$channel->close();

// Cierra la conexión con el servidor RabbitMQ
$connection->close();

?>

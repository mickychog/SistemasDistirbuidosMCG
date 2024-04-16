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

// Declara una cola en RabbitMQ llamada 'hello'
$channel->queue_declare('hello', false, false, false, false);

// Crea un mensaje AMQP con el contenido 'Hello World!'
$msg = new AMQPMessage('Hola Sistemas Distribuidos!');

// Publica el mensaje en la cola 'hello'
$channel->basic_publish($msg, '', 'hello');

// Imprime un mensaje indicando que el mensaje se ha enviado correctamente
echo " [x] Sent 'Hola Sistemas Distribuidos!'\n";

// Cierra el canal de comunicación
$channel->close();

// Cierra la conexión con el servidor RabbitMQ
$connection->close();

?>

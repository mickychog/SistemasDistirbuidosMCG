<?php

// Incluye el archivo autoload.php de Composer para cargar las clases de PhpAmqpLib
require_once __DIR__ . '/vendor/autoload.php';

// Importa la clase AMQPStreamConnection de PhpAmqpLib
use PhpAmqpLib\Connection\AMQPStreamConnection;

// Establece una conexión con el servidor RabbitMQ
$connection = new AMQPStreamConnection('localhost', 5672, 'guest', 'guest');

// Crea un canal de comunicación con RabbitMQ
$channel = $connection->channel();

// Declara un intercambio (exchange) en RabbitMQ llamado 'logs' con el tipo 'fanout'
$channel->exchange_declare('logs', 'fanout', false, false, false);

// Declara una cola anónima en RabbitMQ
list($queue_name, ,) = $channel->queue_declare("", false, false, true, false);

// Hace un enlace entre la cola y el intercambio 'logs'
$channel->queue_bind($queue_name, 'logs');

// Imprime un mensaje indicando que el script está esperando logs
echo " [*] Waiting for logs. To exit press CTRL+C\n";

// Función de devolución de llamada para manejar los logs recibidos
$callback = function ($msg) {
    // Imprime el contenido del log recibido
    echo ' [x] ', $msg->getBody(), "\n";
};

// Consume logs de la cola anónima y pasa la función de devolución de llamada para manejarlos
$channel->basic_consume($queue_name, '', false, true, false, false, $callback);

// Intenta consumir logs de la cola
try {
    $channel->consume();
} catch (\Throwable $exception) {
    // Captura cualquier excepción que pueda ocurrir durante la consumición de logs
    echo $exception->getMessage();
}

// Cierra el canal de comunicación
$channel->close();

// Cierra la conexión con el servidor RabbitMQ
$connection->close();

?>

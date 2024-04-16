<?php

// Incluye el archivo autoload.php de Composer para cargar las clases de PhpAmqpLib
require_once __DIR__ . '/vendor/autoload.php';

// Importa la clase AMQPStreamConnection de PhpAmqpLib
use PhpAmqpLib\Connection\AMQPStreamConnection;

// Establece una conexión con el servidor RabbitMQ
$connection = new AMQPStreamConnection('localhost', 5672, 'guest', 'guest');

// Crea un canal de comunicación con RabbitMQ
$channel = $connection->channel();

// Declara una cola en RabbitMQ llamada 'task_queue'
$channel->queue_declare('task_queue', false, true, false, false);

// Imprime un mensaje indicando que el script está esperando mensajes
echo " [*] Waiting for messages. To exit press CTRL+C\n";

// Función de devolución de llamada para manejar los mensajes recibidos
$callback = function ($msg) {
    // Imprime el cuerpo del mensaje recibido
    echo ' [x] Received ', $msg->getBody(), "\n";
    
    // Simula el procesamiento del mensaje esperando un número de segundos igual al número de puntos en el mensaje
    sleep(substr_count($msg->getBody(), '.'));

    // Imprime un mensaje indicando que el procesamiento del mensaje ha terminado
    echo " [x] Done\n";

    // Confirma que el mensaje ha sido procesado correctamente (acknowledge)
    $msg->ack();
};

// Configura el canal para que no entregue más de un mensaje a la vez al consumidor
$channel->basic_qos(null, 1, false);

// Consume mensajes de la cola 'task_queue' y pasa la función de devolución de llamada para manejarlos
$channel->basic_consume('task_queue', '', false, false, false, false, $callback);

// Intenta consumir mensajes de la cola
try {
    $channel->consume();
} catch (\Throwable $exception) {
    // Captura cualquier excepción que pueda ocurrir durante la consumición de mensajes
    echo $exception->getMessage();
}

// Cierra el canal de comunicación
$channel->close();

// Cierra la conexión con el servidor RabbitMQ
$connection->close();

?>

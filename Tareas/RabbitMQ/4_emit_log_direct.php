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

// Declara un intercambio (exchange) en RabbitMQ llamado 'direct_logs' con el tipo 'direct'
$channel->exchange_declare('direct_logs', 'direct', false, false, false);

// Obtiene el nivel de severidad de los logs del primer argumento de la línea de comandos, si está presente, de lo contrario, establece el nivel de severidad en 'info' por defecto
$severity = isset($argv[1]) && !empty($argv[1]) ? $argv[1] : 'info';

// Obtiene el mensaje de los argumentos de la línea de comandos, si están presentes, de lo contrario, establece un mensaje predeterminado
$data = implode(' ', array_slice($argv, 2));
if (empty($data)) {
    $data = "Hello World!";
}

// Crea un mensaje AMQP con el contenido especificado
$msg = new AMQPMessage($data);

// Publica el mensaje en el intercambio 'direct_logs' con la clave de enrutamiento determinada por el nivel de severidad
$channel->basic_publish($msg, 'direct_logs', $severity);

// Imprime un mensaje indicando que el mensaje se ha enviado correctamente, mostrando el nivel de severidad y el contenido del mensaje
echo ' [x] Sent ', $severity, ':', $data, "\n";

// Cierra el canal de comunicación
$channel->close();

// Cierra la conexión con el servidor RabbitMQ
$connection->close();

?>

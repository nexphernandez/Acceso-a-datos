<?php
    $ruta ="ficheros/tweets.txt";
    $tweets = fopen($ruta, "a+");
    $fecha = date_format(date_create(), "Y m d H:i");
    $tweet = readline("Escribe tu tweet:");
    fwrite($tweets, "[$fecha] @usuario: $tweet\n");
    fclose($tweets);
    echo file_get_contents($ruta) . "\n";
?>
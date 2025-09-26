<?php
    $ruta = "ficheros/frase.txt";
    $rutaDestino = "ficheros/frase_invertida.txt";

    $contenido = file_get_contents($ruta);
    
    $invertido = strrev($contenido);

    file_put_contents($rutaDestino, $invertido);
?>
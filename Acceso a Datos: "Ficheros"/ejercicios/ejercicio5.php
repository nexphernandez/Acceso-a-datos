<?php
    $rutaOrigen = "ficheros/origen.txt";
    $rutaDestino = "ficheros/copia.txt";

    $texto = file_get_contents($rutaOrigen);

    file_put_contents($rutaDestino, $texto);

?>
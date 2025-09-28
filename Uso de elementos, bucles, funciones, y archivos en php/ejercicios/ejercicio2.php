<?php
    $ruta = "files/texto.txt";

    $contenido = file_get_contents($ruta);
    $limpio = str_replace([",", "\n", "\r", "."], " ", $contenido);
    $palabras = array_filter(explode(" ", $limpio));
    $conteo = [];
    foreach ($palabras as $palabra) {
        $palabra = strtolower(trim($palabra));
        if (isset($conteo[$palabra])) {
            $conteo[$palabra]++;
        }else{
            $conteo[$palabra] = 1;
        }
    }
    foreach ($conteo as $palabra => $cantidad) {
    echo "$palabra: $cantidad\n";
    }
?>
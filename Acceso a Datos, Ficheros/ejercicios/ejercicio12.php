<?php
    $ruta = "ficheros/ranking.txt";
    $lineas = file($ruta, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    $ranking = [];
    foreach($lineas as $linea){
        List($juego, $puntos) = explode(":", $linea);
        $ranking[trim($juego)] = (int) trim($puntos);
    }
    arsort($ranking);

    $contador = 0;
    foreach ($ranking as $juego => $puntos) {
        echo "$juego: $puntos\n";
        $contador++;
        if ($contador == 3){
            break;
        }
    }
?>
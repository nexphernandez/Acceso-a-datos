<?php
    $nombres = ["Nico", "Carlos", "David"];
    $ruta = "ficheros/nombres.txt";
    $file = fopen($ruta, "r+");
    foreach ($nombres as $nombre) {
        fwrite($file, $nombre . "\n");
    }
    rewind($file);
    while(($linea = fgets($file)) !== false){
        echo $linea;
    }
    fclose($file);
?>
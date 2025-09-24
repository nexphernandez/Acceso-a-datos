<?php
    $ruta ="ficheros/numeros.txt";
    $file = fopen($ruta, "r+");
    for ($i=1; $i <=10 ; $i++) { 
        fwrite($file, $i . "\n");
    }
    rewind($file);
    echo fread($file, filesize($ruta));
    fclose($file);
?>
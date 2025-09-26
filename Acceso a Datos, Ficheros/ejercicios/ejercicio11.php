<?php
    $ruta = "ficheros/diario.txt";
    $file = fopen($ruta, "a+");
    $fecha = date_format(date_create(), "Y-m-d  H:i");
    $entrada = readline("¿Que hiciste hoy?\n");
    fwrite($file, "[$fecha] $entrada\n");
    fclose($file);
    echo file_get_contents($ruta);
?>
<?php
    $ruta = "ficheros/canciones.txt";
    $canciones = file($ruta);
    $random = array_rand($canciones);
    echo $canciones[$random];
?>
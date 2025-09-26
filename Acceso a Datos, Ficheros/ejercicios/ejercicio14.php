<?php
    $ruta = "ficheros/excusas.txt";
    $excusas = file($ruta);
    $ramdom = array_rand($excusas);
    echo $excusas[$ramdom];
?>
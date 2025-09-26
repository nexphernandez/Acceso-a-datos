<?php
    $ruta = "ficheros/datos_numericos.txt";
    $numerosStr = file_get_contents($ruta);
    $numeros = explode(",",$numerosStr);
    echo $suma = array_sum($numeros). "\n";
?>
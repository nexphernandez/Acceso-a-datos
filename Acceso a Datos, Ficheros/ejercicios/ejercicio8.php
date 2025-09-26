<?php
    $ruta= "ficheros/tabla5.txt";
    $file = fopen($ruta, "w+");
    $multiplicacion = 0;
    for ($i=1; $i <=10; $i++) { 
        $multiplicacion = 5 * $i;
        fwrite($file, "5 x $i = $multiplicacion \n");
    }
    fclose($file);
    echo file_get_contents(filename: $ruta);
?>
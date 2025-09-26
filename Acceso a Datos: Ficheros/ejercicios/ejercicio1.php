<?php
    /*
    $file = fopen("ficheros/datos.txt" , "r+");
    fwrite($file, "Hola mundo desde PHP \n");
    rewind($file);
    echo fread($file, filesize("ficheros/datos.txt"));
    fclose($file);
    */
    $ruta ="ficheros/datos.txt";
    file_put_contents($ruta,"Hola mundo desde PHP \n");
    echo file_get_contents($ruta);
?>
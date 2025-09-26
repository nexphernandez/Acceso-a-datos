<?php
    $ruta = "ficheros/datos.json";
    $contenido = file_get_contents($ruta);
    $personas = json_decode($contenido, true);
    foreach($personas as $persona){
        echo "Nombre: ". $persona["nombre"] . " - Edad: " . $persona["edad"] . "\n";
    }
?>
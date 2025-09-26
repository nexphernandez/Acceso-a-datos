<?php
    $ruta= "ficheros/texto.txt";
    $frase = file_get_contents($ruta);
    $palabras = str_word_count($frase);
    echo $palabras . "\n";
?>
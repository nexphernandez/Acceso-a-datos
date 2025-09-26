<?php
    $palabras = file("ficheros/palabras.txt");
    $ramdom = array_rand($palabras);
    $palabra = $palabras[$ramdom];
    $palabraArray = str_split($palabra);
    echo "Adivina la palabra que empieza por :" . $palabraArray[0] . $palabraArray[1]."\n";
    $respuesta = readLine("Escribe la palabra aqui:");
    if ($respuesta === $palabra) {
        echo "Acertaste";
    }else{
        echo "Fallaste la palabra era: " . $palabra;
    }

?>
<?php
    $plantilla = file_get_contents("ficheros/plantilla.txt");

    $animales = file("ficheros/animales2.txt", FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    $lugares  = file("ficheros/lugares.txt", FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    $comidas  = file("ficheros/comidas2.txt", FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

    $plantilla = str_replace("[animal]", $animales[array_rand($animales)], $plantilla);

    $plantilla = str_replace("[lugar]", $lugares[array_rand($lugares)], $plantilla);

    $plantilla = str_replace("[comida]", $comidas[array_rand($comidas)], $plantilla);

    echo $plantilla . "\n";
?>
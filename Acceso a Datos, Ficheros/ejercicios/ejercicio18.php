<?php
    $ruta = "ficheros/comidas.txt";
    $file = fopen($ruta, "a+");
    $comidaFavorita = readline("¿Cual es tu comida favorita?:");
    fwrite($file, $comidaFavorita ."\n");
    fclose($file);
    $comidas = file($ruta);
    $comidasChekeadas = [];
    foreach($comidas as $comida){
        $comida= trim($comida);
        if(!isset($comidasChekeadas[$comida])){
            $comidasChekeadas[$comida] = 1;
        }else{
            $comidasChekeadas[$comida]++;
        }
    }
    echo "Conteo de comidas:\n";
    foreach ($comidasChekeadas as $comida => $cantidad) {
        echo "$comida: $cantidad\n";
    }
?>
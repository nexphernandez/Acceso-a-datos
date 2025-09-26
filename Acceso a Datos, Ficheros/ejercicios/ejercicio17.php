<?php
    $adjetivos = file("ficheros/adjetivos.txt");
    $adRamdom = array_rand($adjetivos);
    $adjetivo = $adjetivos[$adRamdom];
    $animales = file("ficheros/animales.txt");
    $anRamdom = array_rand($animales);
    $animal = $animales[$anRamdom];
    
    echo trim($adjetivo) . " " . trim($animal) . "\n";
?>
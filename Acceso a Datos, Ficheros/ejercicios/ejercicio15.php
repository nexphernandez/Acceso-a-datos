<?php
    $chistes = file("ficheros/chistes.txt");
    $random = array_rand($chistes);
    echo $chistes[$random];
?>
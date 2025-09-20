<?php
    declare(strict_types=1);
    function montañaAsteriscos(int $n, $m): void{
        $altura = $n *$m;
        for ($i=1; $i < $altura ; $i++) { 
            $izquierda = str_repeat("*", $i);
            $espacios = str_repeat(" ", $altura - ($i * 2) );
            $derecha = str_repeat("*",$i);

            echo $izquierda . $espacios . $derecha . "\n";
        }
    }

    montañaAsteriscos(4,2);
?>
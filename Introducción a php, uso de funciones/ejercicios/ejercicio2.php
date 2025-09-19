<?php
    declare(strict_types=1);
    function montañaAsteriscos(int $n, $m): void{
        for ($i=1; $i < $n * $m ; $i++) { 
            echo str_repeat("*", $i);
            echo str_repeat("*", $n * $m - $i +1). "\n";
        }
    }

    echo montañaAsteriscos(4,2) . "\n";
?>
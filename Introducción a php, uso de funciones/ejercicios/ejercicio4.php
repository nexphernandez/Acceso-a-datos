<?php
    declare(strict_types=1);
    function multiplosTresOCinco(int $n): array{
        $array = [];
        for ($i=1; $i < $n ; $i++) { 
            if ($i % 3 == 0 || $i % 5 == 0) {
                $array[] = $i;
            }
        }
        return $array;
    }

    $multiplos = multiplosTresOCinco(10);
    echo implode(", ", $multiplos) . "\n";
    echo "Suma = " . array_sum($multiplos) . "\n";
?>
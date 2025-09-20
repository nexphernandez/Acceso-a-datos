<?php
    declare(strict_types=1);
    function secuenciaCollatz(int $n): array{
        $array = [$n];
        while ($n != 1) {
            if ($n % 2 === 0) {
            $n /= 2;
            $array[] = $n;
        }else{
            $n *= 3;
            $n += 1; 
            $array[] = $n;
        }
        }
        return $array;
    }

    $secuencia = secuenciaCollatz(6);
    echo implode(", ", $secuencia);
?>
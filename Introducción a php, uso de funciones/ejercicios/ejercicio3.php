<?php
    declare(strict_types=1);
    function sumaDigitos(int $n): int{
        $numeroStr = (String) $n;
        $array = str_split($numeroStr);
        $suma = 0;
        $tamanio = count($array);
        for ($i=0; $i < $tamanio ; $i++) { 
            $numero = (int) $array[$i];
            $suma += $numero;
        }
        return $suma;
    }

    echo sumaDigitos(2025);
?>
<?php
    declare(strict_types=1);
    function esCapicua(int $n):String{
        $numero1 = (string) $n;
        $numero2 = strrev($numero1);
        if($numero2 == $numero1){
            return "true";
        } 
        return "false";
    }
    echo esCapicua(12345) . "\n";
    echo esCapicua(12321) . "\n";
?>
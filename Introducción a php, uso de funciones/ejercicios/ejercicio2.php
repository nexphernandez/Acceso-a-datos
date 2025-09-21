<?php
declare(strict_types=1);
function montañaAsteriscos(int $altura, int $repeticiones): void {
    for ($i = 1; $i <= $altura; $i++) {
        $linea = "";
        $espacios = ($altura - $i) * 2;

        for ($j = 1; $j <= $repeticiones; $j++) {
            if ($j % 2 == 0) { 
                $linea .= str_repeat(" ", $espacios) . str_repeat("*", $i);
            } else {           
                $linea .= str_repeat("*", $i);
            }
        }

        echo $linea . "\n";
    }
}

montañaAsteriscos(4, 3);
?>
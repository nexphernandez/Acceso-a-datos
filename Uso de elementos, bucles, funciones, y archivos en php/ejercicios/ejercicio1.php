<?php
    $ruta = "files/ops.csv";
    $operaciones = file($ruta);
    $solucion = [];
    foreach ($operaciones as $linea) {
        $frase = explode(",",trim($linea));

        list($a, $b, $op) = $frase; 
        $a = (float)$a;
        $b = (float)$b;

        $resultado = calcular($a,$b,$op);
        $solucion[] = "$a , $b, $op, $resultado";
    }

    foreach ($solucion as $respuesta) {
        echo $respuesta . "\n";
    }

    
    function calcular(float $a, float $b, string $operacion): int|float|string {
    switch (strtolower(trim($operacion))) {
        case 'suma':
            return $a + $b;
        case 'resta':
            return $a - $b;
        case 'producto':
            return $a * $b;
        case 'division':
            if ($b == 0) {
                return "ERROR: division entre 0";
            }
            return $a / $b;
        default:
            return "Operacion no valida";
    }
}
    
?>
## Número capicúa (palíndromo numérico)

Implementa una función __esCapicua(int $n): bool__ que determine si un número entero positivo es capicúa.

- Un número es capicúa si se lee igual de izquierda a derecha que de derecha a izquierda.

> Ejemplo: `12321` → `true`

```php
<?php
declare(strict_types=1);

function esCapicua(int $n): bool {
    $numeroStr = (string) $n;
    return $numeroStr === strrev($numeroStr);
}

var_dump(esCapicua(12345));
var_dump(esCapicua(12321));
?>
```

## Escalera de asteriscos

Implementa una función __montañaAsteriscos(int $n, $m): void__ que imprima una escalera de asteriscos de altura `N`y el tamaño M.

- La primera fila contiene 1 asterisco, la segunda 2, y así hasta `N`, `M` veces.

> Ejemplo con entrada `4,2`:

```text
*.     *
**.   **
***  ***
********
```

```php
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
```

## Suma de dígitos

Implementa una función __sumaDigitos(int $n): int__ que calcule la suma de los dígitos de un número entero positivo.

- Descompón el número en dígitos y súmalos.

> Ejemplo: `2025` → `9` (2+0+2+5)

```php
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
```

Forma optima
```php
<?php
declare(strict_types=1);
function sumaDigitos(int $n): int {
    $suma = 0;
    while ($n > 0) {
        $suma += $n % 10;
        $n = intdiv($n, 10);
    }
    return $suma;
}

echo sumaDigitos(2025);
?>
```

## Número secreto (múltiplos de 3 o 5)

Implementa una función __multiplosTresOCinco(int $n): array__ que devuelva todos los múltiplos de 3 o 5 menores que `N`.

- Además, calcula la suma de dichos múltiplos.

> Ejemplo con entrada `10`:

```code
3, 5, 6, 9
Suma = 23
```

```php
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
```
Forma optima

```php
<?php
declare(strict_types=1);

$n = 10;

$numeros = range(1, $n - 1);

$multiplos = array_filter($numeros, fn($x) => $x % 3 === 0 || $x % 5 === 0);

echo implode(", ", $multiplos) . "\n";       
echo "Suma = " . array_sum($multiplos) . "\n";
?>
```

## Secuencia de Collatz

Implementa una función __secuenciaCollatz(int $n): array__ que genere la secuencia de Collatz a partir de un entero positivo.

- Si el número es par → dividir entre 2.  
- Si es impar → multiplicar por 3 y sumar 1.  
- Repetir hasta llegar a 1.

> Ejemplo con entrada `6`:

```code
6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1
```

---
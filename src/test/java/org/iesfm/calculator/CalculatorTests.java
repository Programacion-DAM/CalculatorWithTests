package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.ZeroByZeroDivisionException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class CalculatorTests {

    private Calculator calculator = new Calculator();

    // Como vamos a comparar doubles y existe el problema de la precisión, debemos establecer
    // un margen de error aceptable a la hora de comparar. Este margen se denomina DELTA
    private final static double DELTA = 0.000001;

    /*
     * Ahora procedemos a crear escenarios de test (@Test) para cada uno de los métodos de ICalculator.
     * El número de escenarios depende de cuantos casos distintos vemos que existe en cada método.
     *
     * Para la calculadora vamos a establecer los siguientes casos:
     *
     *    - Suma
     *      1. Suma de dos números: 4 + 3 = 7
     *      2. Suma de un número y 0:  4 + 0 = 4
     *    - Resta
     *      3. Restar dos números positivos: 4 - 3 = 1
     *      4. Restar un positivo y un negativo: 4 - (-3) = 7
     *    - Multiplicación
     *      5. Multiplicar dos números: 4 * 3 = 12
     *      6. Multiplicar un número por 0: 4 * 0 = 0
     *    - División
     *      7. División dos números: 12 / 3 = 4
     *      8. División de un número entre 0: 4 / 0 = Double.POSITIVE_INFINITE
     *      9. División de 0 entre 0: 0 / 0 = ZeroByZeroException
     *    - Negación
     *      10. Negación de un positivo: neg(12)  = -12
     *      11. Negación de un negativo: neg(-12)  = 12
     *      12. Negación de 0: neg(0)  = 0
     */

    // ESCENARIOS DE SUMA
    @Test
    public void sumNumbersTest() {
        // Configuración del escenario del test
        double a = 4;
        double b = 3;

        // Ejecución del test
        double res = calculator.sum(a, b);

        // Comprobaciones del test
        Assert.assertEquals(7, res, DELTA);
    }

    @Test
    public void sumNumberAnd0Test() {
        // Configuración del escenario del test
        double a = 4;

        // Ejecución del test
        double res = calculator.sum(a, 0);

        // Comprobaciones del test
        Assert.assertEquals(a, res, DELTA);
    }

    // ESCENARIOS DE RESTA
    @Test
    public void substractNumbersTest() {
        // Configuración del escenario del test
        double a = 4;
        double b = 3;

        // Ejecución del test
        double res = calculator.substract(a, b);

        // Comprobaciones del test
        Assert.assertEquals(1, res, DELTA);
    }

    @Test
    public void substractNumberAndNegativeTest() {
        // Configuración del escenario del test
        double a = 4;
        double b = -3;

        // Ejecución del test
        double res = calculator.substract(a, b);

        // Comprobaciones del test
        Assert.assertEquals(7, res, DELTA);
    }

    // ESCENARIOS DE MULTIPLICACION
    @Test
    public void multiplyNumbersTest() {
        // Configuración del escenario del test
        double a = 4;
        double b = 3;

        // Ejecución del test
        double res = calculator.multiply(a, b);

        // Comprobaciones del test
        Assert.assertEquals(12, res, DELTA);
    }

    @Test
    public void multiplyNumberAnd0Test() {
        // Configuración del escenario del test
        double a = 4;

        // Ejecución del test
        double res = calculator.multiply(a, 0);

        // Comprobaciones del test
        Assert.assertEquals(0, res, DELTA);
    }

    // ESCENARIOS DE DIVISION
    // Como el método calculator.div lanza la excepción ZeroByZeroDivisionException hay que propagarla
    // en los tests para así poder comprobar si se lanza cuando así se espera
    @Test
    public void divideTest() throws ZeroByZeroDivisionException {
        // Configuración del escenario del test
        double a = 12;
        double b = 3;

        // Ejecución del test
        double res = calculator.div(a, b);

        // En este test se espera que NO se lance la excepción por lo que añadimos un assert
        // depués de la ejecución del test para comprobar el resultado
        Assert.assertEquals(4, res, DELTA);
    }

    @Test
    public void divideByZeroTest() throws ZeroByZeroDivisionException {
        // Configuración del escenario del test
        double a = 12;
        double b = 0;

        // Ejecución del test
        double res = calculator.div(a, b);

        // En este test se espera que NO se lance la excepción por lo que añadimos un assert
        // depués de la ejecución del test para comprobar el resultado
        Assert.assertEquals(Double.POSITIVE_INFINITY, res, DELTA);
    }

    @Test(expected = ZeroByZeroDivisionException.class)
    public void divideZeroByZeroTest() throws ZeroByZeroDivisionException {
        // Configuración del escenario del test

        double a = 0;
        double b = 0;
        calculator.div(a, b);

        // En este test se espera que SE LANCE la excepción por lo NO HAY MAS CODIGO después
        // de la ejecución del test, en su lugar ponemos en la cabecera del método del test
        // que se espera que se produzca la excepción ZeroByZeroDivisionException
        // @Test(expected = ZeroByZeroDivisionException.class)
    }
}

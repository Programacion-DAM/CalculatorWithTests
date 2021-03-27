package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.ZeroByZeroDivisionException;

/**
 * Provee funcionalidad de una calculadora básica
 */
public interface ICalculator {

    /**
     * Suma el parámetro a y b
     *
     * @param a El primer sumando
     * @param b El segundo sumando
     * @return Devuelve la suma
     */
    double sum(double a, double b);

    /**
     * Resta el parámetro a y b
     *
     * @param a El primer operando
     * @param b El segundo operando
     * @return Devuelve la resta
     */
    double substract(double a, double b);

    /**
     * Divide el parámetro a entre b
     *
     * @param a El dividendo
     * @param b El divisor
     * @return El resutlado de la división
     * @throws ZeroByZeroDivisionException Ocurre se intenta dividir 0 entre 0
     */
    double div(double a, double b) throws ZeroByZeroDivisionException;

    /**
     * Multiplica el parámetro a y b
     *
     * @param a El primer operando
     * @param b El segundo operando
     * @return Devuelve la multiplicación
     */
    double multiply(double a, double b);

    /**
     * Cambia el signo de a
     *
     * @param a El valor al que se le va a cambiar el signo
     * @return Devuelve -a
     */
    double neg(double a);

}

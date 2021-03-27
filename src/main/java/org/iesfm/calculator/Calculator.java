package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.ZeroByZeroDivisionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator implements ICalculator {

    @Override
    public double sum(double a, double b) {
        return a + b;
    }

    @Override
    public double substract(double a, double b) {
        return a - b;
    }

    @Override
    public double div(double a, double b) throws ZeroByZeroDivisionException {
        if (a == 0 && b == 0) {
            // Lanzamos la excepción si a y b son 0, esta operación es una indeterminación
            // Aquí no hay try ... catch porque lo que nos interesa es propagar la excepción
            // hacia fuera de este método, esto se consigue gracias al throws ZeroByZeroDivisionException
            // que hay en la cabecera del método
            throw new ZeroByZeroDivisionException();
        }
        // Si el programa ha llegado hasta aquí significa que no se ha lanzado la excepción ZeroByZeroDivisionException
        // que habría provocado que la ejecución de este método finalizara

        return a / b;

    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double neg(double a) {
        return -a;
    }
}

package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.ZeroByZeroDivisionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double a = askNumber();
        double b = askNumber();
        try {
            double res = calculator.div(a, b);
            log.info("El resultado de la división es " + res);
        } catch (ZeroByZeroDivisionException e) {
            // Llega aquí cuando el usuario ha dos ceros
            log.error("No es posible dividir 0 entre 0");
        }
    }

    /**
     * Este método pide un número decimal al usuario. Si se introduce un valor no númerico
     * muestra un mensaje de erorr y vuelve a pedir un número
     *
     * @return
     */
    private static double askNumber() {
        Double number = null;
        while (number == null) {
            try {
                log.info("Introduzca un número decimal");
                number = scan.nextDouble();
                scan.nextLine();
            } catch (InputMismatchException e) {
                // Llega aquí si el usuario mete un valor no numérico
                scan.nextLine();
                log.error("Debe introducir un número");
            }
        }

        return number;
    }
}

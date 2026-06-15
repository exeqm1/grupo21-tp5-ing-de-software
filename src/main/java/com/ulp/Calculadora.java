package com.ulp;

public class Calculadora {

    public double sum(double a, double b) {
        return a + b;
    }

    public double res(double a, double b) {
        return a - b;
    }

    public double mult(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }
}
    

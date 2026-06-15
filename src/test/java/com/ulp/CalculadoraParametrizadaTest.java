/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulp;

/**
 *
 * @author edgar
 */
public class CalculadoraParametrizadaTest {
    @ParameterizedTest
    @CsvSource({
        "8.0, 7.0, 15.0",
        "2.0, 0.0, 2.0",
        "10.0, -1.0, 9.0"
    })
    public void testSumaParametrizada(double num1, double num2, double resultadoEsperado) {
        Calculadora calc = new Calculadora();
        assertEquals(resultadoEsperado, calc.sumar(num1, num2), 0.001);
    }
}

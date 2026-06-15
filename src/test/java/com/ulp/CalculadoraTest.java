package com.ulp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    static Calculadora calculadora;

    @BeforeAll
    static void iniciar() {
        calculadora = new Calculadora();
        System.out.println("Bienvenido a las pruebas de la calculadora");
    }

    @BeforeEach
    void antesDeCadaPrueba(TestInfo info) {
        System.out.println("Ejecutando prueba: " + info.getDisplayName());
    }

    @AfterEach
    void despuesDeCadaPrueba() {
        System.out.println("Prueba finalizada, campos en 0");
    }

    @AfterAll
    static void finalizar() {
        System.out.println("La operación ha finalizado");
    }

    @Test
    void testSuma() {
        double resultado = calculadora.sum(8, 7);
        assertEquals(15.0, resultado, 0.001);
    }

    @Test
    void testResta() {
        double resultado = calculadora.res(10, 5);
        assertEquals(5.0, resultado, 0.001);
    }
}
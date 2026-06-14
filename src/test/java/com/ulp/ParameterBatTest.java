package com.ulp;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.jupiter.api.TestInfo;

/**
 *
 * @author juanj
 */
public class ParameterBatTest {
    static Bateria bat;  
    public ParameterBatTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
         bat = new Bateria();
    }
      
    @BeforeEach
    public void setUp(TestInfo testInfo) {
        String nombreMetodo = testInfo.getTestMethod().map(m -> m.getName()).orElse("desconocido");
        // Si el test tiene un DisplayName, también lo podemos capturar aquí:
        String displayName = testInfo.getDisplayName();
        System.out.printf("-- Prueba: %s [%s] --\n", nombreMetodo, displayName);
    }
   
    @AfterEach
    public void tearDown() {
        System.out.println("FIN prueba");
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5}) // Se ejecutará 3 veces, una con cada número
    public void testDescargarParametrizado(int metrosParam) {
        System.out.println("Descargando con metros: " + metrosParam);
        double result = bat.descargar(metrosParam);
        // Tu aserción aquí...
        assertNotNull(result);
    }
    
   @RepeatedTest(10)
    void pruebaRepetidaBasica() {
        // Esta prueba se ejecutará 10 veces exactamente
        int numeroAleatorio = (int) (Math.random() * 100);
        System.out.println("Aleatorio " +numeroAleatorio);
        assertTrue(numeroAleatorio >= 0 && numeroAleatorio <= 100);
    }

    @RepeatedTest(value = 10, name = "Ejecución {currentRepetition} de {totalRepetitions}")
    void pruebaConInformacion(RepetitionInfo repetitionInfo) {
        System.out.println("Ejecutando la repetición: " + repetitionInfo.getCurrentRepetition());
        assertTrue(repetitionInfo.getCurrentRepetition() <= 10);
    }
    
    @RepeatedTest(3)
    public void testCargar() {
        System.out.println("cargando 3 veces...");
        double volts = (Math.random() * 6);
        
        // El resultado esperado cambia en cada iteración
        double expResult = volts + bat.carga; 
        double actualResult = bat.cargar(1, volts);
        System.out.println("generó: esperado " + expResult + " y real "+ actualResult);
        // assertEquals valida un expResult distinto cada vez
        assertEquals(expResult, actualResult, "Falló en la repetición ");
    }
   
    
    // Si solo quieren medir el tiempo de una línea de código específica dentro del test, usas assertTimeout
    @Test
  //  @Disabled("Para deshabilitar pruebas temporalmente")
    public void testDescargarConTimeout() {
        // Verifica que todo lo que esté adentro de la función lambda tome menos de 500 milisegundos
        assertTimeout(Duration.ofMillis(500), () -> {
            bat.descargar(5);
        });
    }
    
}

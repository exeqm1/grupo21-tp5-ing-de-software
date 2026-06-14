package com.ulp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author juanj
 */
@DisplayName("PROGRAMA DE CARGA y DESCARGA")
public class BateriaTest {
    public static Bateria bat ;
    static int metros;
    public BateriaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
         metros = 3;
         bat = new Bateria();
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("FIN de las pruebas");
    }
    
   @BeforeEach
    public void setUp() {
         System.out.printf("Hola %s, recorres %d metros.", "Juanjo", metros);
       }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
   @DisplayName("Test de Carga iniciado")
    public void testCargar() {
        System.out.println("cargando...");
       
        double voltaje = 1.3;
        double expResult = 2.4;
      //  double expResult = 3.9;
        double result = bat.cargar(metros, voltaje);
        assertEquals(expResult, result, 0.005);
        
    }

    @Test
    public void testDescargar() {
        System.out.println("descargar");
       
        double expResult = -1.5;
        double result = bat.descargar(metros);
        assertEquals(expResult, result, 0.05);
       
    }
    
    //@Test(expected = IllegalArgumentException.class). En JUnit 5 eso ya no existe. Ahora se usa assertThrows()
    @Test 
    @DisplayName("Test de Voltaje Negativo lanza Excepción")
    public void testVoltajeNegativo() {
        // Verifica que si se pasa un voltaje de -5.0, el método lance IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            bat.cargar(3, -5.0); 
        });
    }
  
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS) // Si tarda más de 1 segundo, falla
    @DisplayName("Test con límite de tiempo")
    public void testMetodoRapido() {
        System.out.println("Ejecutando prueba rápida...");
        bat.cargar(10, 1.5);
}



}

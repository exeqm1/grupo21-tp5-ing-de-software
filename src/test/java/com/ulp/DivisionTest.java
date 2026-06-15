
package com.ulp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author camila biarnes
 */
public class DivisionTest {
    @Test
    void testDivisionCero() {
        Calculadora calc = new Calculadora();
        assertThrows(ArithmeticException.class, () -> {
            calc.div(10.0, 0.0);
        });
    }
}

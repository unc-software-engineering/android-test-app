package test.jnonino.testapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class CalculadoraTest {

    private CalculadoraActivity calculadora;

    @Before
    public void setUp() {
        calculadora = new CalculadoraActivity();
    }

    @Test
    public void testSumaNatural() {
        double expectedResult = 5;
        double actualResult = calculadora.sumar(2, 3);
        double deltaAceptado = 0;
        assertEquals("Probar Suma Natural", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testSumaEntera() {
        double expectedResult = -1;
        double actualResult = calculadora.sumar(2, -3);
        double deltaAceptado = 0;
        assertEquals("Probar Suma Entera", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testSumaDecimal() {
        double expectedResult = -0.9;
        double actualResult = calculadora.sumar(2.5, -3.4);
        double deltaAceptado = 0.1;
        assertEquals("Probar Suma Decimal", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testRestaNatural() {
        double expectedResult = 6;
        double actualResult = calculadora.restar(9, 3);
        double deltaAceptado = 0;
        assertEquals("Probar Resta Natural", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testRestaEntera() {
        double expectedResult = 12;
        double actualResult = calculadora.restar(9, -3);
        double deltaAceptado = 0;
        assertEquals("Probar Resta Entera", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testRestaDecimal() {
        double expectedResult = -8.4;
        double actualResult = calculadora.restar(-2.5, 5.9);
        double deltaAceptado = 0.1;
        assertEquals("Probar Resta Decimal", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testMultiplicacionNatural() {
        double expectedResult = 27;
        double actualResult = calculadora.multiplicar(9, 3);
        double deltaAceptado = 0;
        assertEquals("Probar Multiplicacion Natural", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testMultiplicacionEntera() {
        double expectedResult = -27;
        double actualResult = calculadora.multiplicar(9, -3);
        double deltaAceptado = 0;
        assertEquals("Probar Multiplicacion Entera", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testMultiplicacionDecimal() {
        double expectedResult = -14.75;
        double actualResult = calculadora.multiplicar(-2.5, 5.9);
        double deltaAceptado = 0.1;
        assertEquals("Probar Multiplicacion Decimal", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testDivisionNatural() {
        double expectedResult = 3;
        double actualResult = calculadora.dividir(9, 3);
        double deltaAceptado = 0;
        assertEquals("Probar Division Natural", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testDivisionEntera() {
        double expectedResult = -3;
        double actualResult = calculadora.dividir(9, -3);
        double deltaAceptado = 0;
        assertEquals("Probar Division Entera", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testDivisionDecimal() {
        double expectedResult = -0.423;
        double actualResult = calculadora.dividir(-2.5, 5.9);
        double deltaAceptado = 0.1;
        assertEquals("Probar Division Decimal", expectedResult, actualResult, deltaAceptado);
    }

    @Test
    public void testDivisionPorCero() {
        try {
            calculadora.dividir(20,0);
            fail("Al dividir por cero de deberia haber lanzado una excepcion");
        } catch (RuntimeException e) {
            String actualMessage = e.getMessage();
            assertEquals("Probando Division por Cero", CalculadoraActivity.ERROR_DIVISION_POR_CERO, actualMessage);
        }
    }
}
package TDD;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraDescontoTDD_Test {

    @Test
    public void deveLancarExcecaoParaValorZerado() {
        CalculadoraDescontoTDD calculadora = new CalculadoraDescontoTDD();
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularValorFinal(0.0, false);
        });
    }

    @Test
    public void deveCobrarFreteParaPedidoAbaixoDe100() {
        CalculadoraDescontoTDD calculadora = new CalculadoraDescontoTDD();
        double resultado = calculadora.calcularValorFinal(50.0, false);
        assertEquals(65.0, resultado, 0.01); // 50 + 15 de frete
    }

    @Test
    public void deveAplicarDezPorCentoDeDescontoAcimaDe500() {
        CalculadoraDescontoTDD calculadora = new CalculadoraDescontoTDD();
        double resultado = calculadora.calcularValorFinal(600.0, false);
        assertEquals(540.0, resultado, 0.01); // 600 - 10%
    }

    @Test
    public void deveAplicarVintePorCentoDeDescontoAcimaDe1000() {
        CalculadoraDescontoTDD calculadora = new CalculadoraDescontoTDD();
        double resultado = calculadora.calcularValorFinal(2000.0, false);
        assertEquals(1600.0, resultado, 0.01); // 2000 - 20%
    }
}

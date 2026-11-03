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

    @Test
    public void deveAplicarDescontoVipAcumulativo() {
        CalculadoraDescontoTDD calculadora = new CalculadoraDescontoTDD();
        // 600 - 10% = 540 -> 540 - 5% = 513
        double resultado = calculadora.calcularValorFinal(600.0, true);
        assertEquals(513.0, resultado, 0.01);
    }

    @Test
    public void deveCobrarFreteQuandoDescontoVipReduzValorParaAbaixoDe100() {
        CalculadoraDescontoTDD calculadora = new CalculadoraDescontoTDD();
        // 100 - 5% = 95. Como 95 < 100, paga frete de 15. Final = 110.
        double resultado = calculadora.calcularValorFinal(100.0, true);
        assertEquals(110.0, resultado, 0.01);
    }
}

package CFTL;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraDescontoTradicionalTest {

    private final CalculadoraDescontoTradicional calculadora = new CalculadoraDescontoTradicional();

    @Test
    public void deveLancarExcecaoParaValorZerado() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularValorFinal(0.0, false);
        });
    }

    @Test
    public void deveLancarExcecaoParaValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularValorFinal(-50.0, true);
        });
    }

    @Test
    public void deveCobrarFreteParaPedidoAbaixoDe100SemDesconto() {
        // R$ 80,00 + R$ 15,00 de frete = R$ 95,00
        double resultado = calculadora.calcularValorFinal(80.0, false);
        assertEquals(95.0, resultado, 0.01);
    }

    @Test
    public void deveCobrarFreteQuandoDescontoVipReduzValorParaMenosDe100() {
        // R$ 100,00 com 5% vip = 95,00 (< 100) + R$ 15,00 de frete = R$ 110,00
        double resultado = calculadora.calcularValorFinal(100.0, true);
        assertEquals(110.0, resultado, 0.01);
    }

    @Test
    public void naoDeveAplicarDescontoNemFreteParaPedidoComumEntre100E500() {
        // Exatamente R$ 500,00 não é "acima de 500", portanto 0% de desconto e sem frete
        double resultado = calculadora.calcularValorFinal(500.0, false);
        assertEquals(500.0, resultado, 0.01);
    }

    @Test
    public void deveAplicar10PorCentoParaComprasAcimaDe500() {
        // R$ 600,00 - 10% = R$ 540,00
        double resultado = calculadora.calcularValorFinal(600.0, false);
        assertEquals(540.0, resultado, 0.01);
    }

    @Test
    public void deveAplicar10PorCentoMais5PorCentoVipAcimaDe500() {
        // R$ 600,00 - 10% = R$ 540,00 -> - 5% VIP = R$ 513,00
        double resultado = calculadora.calcularValorFinal(600.0, true);
        assertEquals(513.0, resultado, 0.01);
    }

    @Test
    public void deveAplicar20PorCentoParaComprasAcimaDe1000() {
        // R$ 2000,00 - 20% = R$ 1600,00
        double resultado = calculadora.calcularValorFinal(2000.0, false);
        assertEquals(1600.0, resultado, 0.01);
    }

    @Test
    public void deveAplicar20PorCentoMais5PorCentoVipAcimaDe1000() {
        // R$ 2000,00 - 20% = R$ 1600,00 -> - 5% VIP = R$ 1520,00
        double resultado = calculadora.calcularValorFinal(2000.0, true);
        assertEquals(1520.0, resultado, 0.01);
    }
}
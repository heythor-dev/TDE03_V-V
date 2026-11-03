package TDD;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraDescontoTDD_Test {

    @Test
    public void deveLancarExcecaoParaValorZerado() {
        CalculadoraDescontoTDD calculadora = new CalculadoraDescontoTDD();
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcularValorFinal(0.0, false);
        });
    }
}

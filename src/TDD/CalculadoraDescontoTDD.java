package TDD;

public class CalculadoraDescontoTDD {

    public double calcularValorFinal(double valorTotalItens, boolean isVip) {
        if (valorTotalItens <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        if (valorTotalItens < 100.00) {
            return valorTotalItens + 15.00;
        } else {
            return valorTotalItens;
        }
    }
}

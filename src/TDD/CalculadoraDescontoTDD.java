package TDD;

public class CalculadoraDescontoTDD {

    public double calcularValorFinal(double valorTotalItens, boolean isVip) {
        if (valorTotalItens <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        double valorComDesconto = valorTotalItens;

        if (valorTotalItens > 1000.00) {
            valorComDesconto = valorTotalItens * 0.80;
        } else if (valorTotalItens > 500.00) {
            valorComDesconto = valorTotalItens * 0.90;
        }

        if (valorTotalItens < 100.00) {
            return valorComDesconto + 15.00;
        } else {
            return valorComDesconto;
        }
    }
}

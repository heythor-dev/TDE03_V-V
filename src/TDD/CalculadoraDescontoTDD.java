package TDD;

public class CalculadoraDescontoTDD {

    public double calcularValorFinal(double valorTotalItens, boolean isVip) {
        if (valorTotalItens <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        return valorTotalItens;
    }
}

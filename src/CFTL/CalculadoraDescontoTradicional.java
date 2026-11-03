package CFTL;

public class CalculadoraDescontoTradicional {

    public double calcularValorFinal(double valorTotalItens, boolean isVip) {
        validarValor(valorTotalItens);

        double valorComDesconto = calcularDescontoFaixa(valorTotalItens);
        valorComDesconto = aplicarDescontoVip(valorComDesconto, isVip);

        return aplicarFrete(valorComDesconto);
    }

    private void validarValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor total dos itens deve ser maior que zero.");
        }
    }

    private double calcularDescontoFaixa(double valor) {
        if (valor > 1000.00) {
            return valor * 0.80;
        }
        if (valor > 500.00) {
            return valor * 0.90;
        }
        return valor;
    }

    private double aplicarDescontoVip(double valor, boolean isVip) {
        if (isVip) {
            return valor * 0.95;
        } else {
            return valor;
        }
    }

    private double aplicarFrete(double valor) {
        if (valor < 100.00) {
            return valor + 15.00;
        } else {
            return valor;
        }
    }

}
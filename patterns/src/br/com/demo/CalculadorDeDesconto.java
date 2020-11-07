package br.com.demo;

public class CalculadorDeDesconto {

    public double calcula(Orcamento orcamento, Desconto desconto) {
        return desconto.desconta(orcamento);
    }
}

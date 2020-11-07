package br.com.demo;

public class TesteDoStrategy {

    /**
     * Exemplo de utilização do padrão Strategy,
     * usando a calculadora de impostos
     */
    public static void main(String[] args) {
        ICMS icms = new ICMS();
        ISS iss = new ISS();
        Orcamento orcamento = new Orcamento(500.0);

        CalculadorDeImposto calculador = new CalculadorDeImposto();

        calculador.calcula(orcamento, icms);
        calculador.calcula(orcamento, iss);

    }
}

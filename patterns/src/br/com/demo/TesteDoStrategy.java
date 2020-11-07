package br.com.demo;

public class TesteDoStrategy {

    /**
     * Exemplo de utilização do padrão Strategy,
     * usando a calculadora de impostos
     */
    public static void main(String[] args) {
        ICMS icmsComIssComIPKV = new ICMS(new ISS(new IPKV(new IPVV())));

        Orcamento orcamento = new Orcamento(500.0);

        CalculadorDeImposto calculador = new CalculadorDeImposto();

        calculador.calcula(orcamento, icmsComIssComIPKV);

    }
}

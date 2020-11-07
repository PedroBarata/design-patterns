package br.com.demo;

public class TesteDoTemplateMethod {

    /**
     * Exemplo de utilização do padrão TemplateMethod,
     * usando a calculadora de impostos
     */
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(500.0);
        IPKV ipkv = new IPKV();
        IPVV ipvv = new IPVV();

        CalculadorDeImposto calculador = new CalculadorDeImposto();

        calculador.calcula(orcamento, ipkv);
        calculador.calcula(orcamento, ipvv);

    }
}

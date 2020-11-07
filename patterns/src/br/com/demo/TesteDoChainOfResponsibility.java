package br.com.demo;

public class TesteDoChainOfResponsibility {

    /**
     * Exemplo de utilização do padrão Strategy,
     * usando a calculadora de impostos
     */
    public static void main(String[] args) {
        DescontoComMaisDeCincoItens d3 = new DescontoComMaisDeCincoItens();
        DescontoDeVendaCasada d2 = new DescontoDeVendaCasada(d3);
        DescontoAcimaDeQuinhentosReais d1 = new DescontoAcimaDeQuinhentosReais(d2);

        Orcamento orcamento = new Orcamento(500.0);
        orcamento.addItem("LAPIS", 250.0);
        orcamento.addItem("CANETA", 250.0);

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeDesconto();
        double desconto = calculadorDeDesconto.calcula(orcamento, d1);
        System.out.println(desconto);
    }
}

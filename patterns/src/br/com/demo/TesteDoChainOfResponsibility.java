package br.com.demo;

public class TesteDoChainOfResponsibility {

    /**
     * Exemplo de utilização do padrão Strategy,
     * usando a calculadora de impostos
     */
    public static void main(String[] args) {
        DescontoAcimaDeQuinhentosReais d1 = new DescontoAcimaDeQuinhentosReais();
        DescontoComMaisDeCincoItens d2 = new DescontoComMaisDeCincoItens();
        SemDesconto semDesconto = new SemDesconto();
        Orcamento orcamento = new Orcamento(600.0);

        d1.setProximo(d2);
        d2.setProximo(semDesconto);

        CalculadorDeDesconto calculadorDeDesconto = new CalculadorDeDesconto();
        double desconto = calculadorDeDesconto.calcula(orcamento, d1);
        System.out.println(desconto);
    }
}

package br.com.demo;

public class TesteDoState {

    /**
     * Exemplo de utilização do padrão State,
     * usando o desconto extra e os estados de um orçamento
     */
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(500.0);
        orcamento.aplicaDescontoExtra();
        System.out.println("Em aprovacao: " + orcamento.getValor());
        orcamento.aprova();
        orcamento.aplicaDescontoExtra();
        System.out.println("Aprovado: " +orcamento.getValor());
        orcamento.finaliza();

        /*Runtime Exception!*/
        //orcamento.aprova();

    }
}

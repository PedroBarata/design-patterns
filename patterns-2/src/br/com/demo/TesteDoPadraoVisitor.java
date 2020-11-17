package br.com.demo;

public class TesteDoPadraoVisitor {

    /**
     * Teste do padrão Visitor,
     * onde, a partir de uma árvore,
     * manipulamos as informações de cada nó,
     * neste caso, estamos imprimindo a expressão gerada
     * na calculadora.
     */
    public static void main(String[] args) {

        Expressao esquerda = new Subtracao(new Soma(new Numero(5), new Numero(7)), new Numero(10));
        Expressao direita = new Soma(new Numero(2), new Numero(3));
        Expressao soma = new Soma(esquerda, direita);
        int resultado = soma.avalia();

        System.out.println(resultado);

        Visitor visitor = new ImpressoraVisitor();
        Visitor prefixada = new ImpressoraPreFixadaVisitor();
        /**
         * O "soma" "aceita" o visitor na árvore.
         * */
        soma.aceita(visitor);
        System.out.println("\n");
        soma.aceita(prefixada);
    }
}

package br.com.demo;

public class TesteDoInterpreter {
    /**
     * Teste do padrão interpreter,
     * onde é gerada uma árvore recursiva
     * que ela mesmo se "resolve" no final (folhas)
     */

    public static void main(String[] args) {
        Expressao esquerda = new Subtracao(new Soma(new Numero(5), new Numero(7)), new Numero(10));
        Expressao direita = new Soma(new Numero(2), new Numero(3));
        Expressao soma = new Soma(esquerda, direita);
        int resultado = soma.avalia();

        System.out.println(resultado);
    }
}

package br.com.demo;

public class Soma implements Expressao {

    private Expressao expressaoEsquerda;
    private Expressao expressaoDireita;

    public Soma(Expressao expressaoEsquerda, Expressao expressaoDireita) {
        this.expressaoEsquerda = expressaoEsquerda;
        this.expressaoDireita = expressaoDireita;
    }

    @Override
    public int avalia() {
        int resultadoExpressaoDaEsquerda = expressaoEsquerda.avalia();
        int resultadoExpressaoDaDireita = expressaoDireita.avalia();

        return resultadoExpressaoDaEsquerda + resultadoExpressaoDaDireita;
    }

    public Expressao getExpressaoEsquerda() {
        return expressaoEsquerda;
    }

    public Expressao getExpressaoDireita() {
        return expressaoDireita;
    }

    /**
     * O "aceita" recebe um visitor e chama o próprio
     * método novamente (recursivo), passando o próprio
     * objeto (Soma, ou seja, this)
     */
    public void aceita(Visitor visitor) {
        visitor.imprimeSoma(this);
    }
}

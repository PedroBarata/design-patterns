package br.com.demo;

public class Divisao implements Expressao {

    private Expressao expressaoEsquerda;
    private Expressao expressaoDireita;

    public Divisao(Expressao expressaoEsquerda, Expressao expressaoDireita) {
        this.expressaoEsquerda = expressaoEsquerda;
        this.expressaoDireita = expressaoDireita;
    }

    @Override
    public int avalia() {
        int resultadoExpressaoDaEsquerda = expressaoEsquerda.avalia();
        int resultadoExpressaoDaDireita = expressaoDireita.avalia();
        return resultadoExpressaoDaEsquerda / resultadoExpressaoDaDireita;
    }
}

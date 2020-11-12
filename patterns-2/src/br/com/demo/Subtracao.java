package br.com.demo;

public class Subtracao implements Expressao {

    private Expressao expressaoEsquerda;
    private Expressao expressaoDireita;

    public Subtracao(Expressao expressaoEsquerda, Expressao expressaoDireita) {
        this.expressaoEsquerda = expressaoEsquerda;
        this.expressaoDireita = expressaoDireita;
    }

    @Override
    public int avalia() {
        int resultadoExpressaoDaEsquerda = expressaoEsquerda.avalia();
        int resultadoExpressaoDaDireita = expressaoDireita.avalia();

        return resultadoExpressaoDaEsquerda - resultadoExpressaoDaDireita;
    }
}

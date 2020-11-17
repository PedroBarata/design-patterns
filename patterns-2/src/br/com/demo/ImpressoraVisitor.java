package br.com.demo;

public class ImpressoraVisitor implements Visitor {
    /**
     * Classe visitor, onde visita cada nó (expressao)
     * e executa uma determinada acao.
     * Para isso, o nó tem que ter conhecimento deste método.
     */
    @Override
    public void imprimeSoma(Soma soma) {
        System.out.print("(");
        soma.getExpressaoEsquerda().aceita(this);
        System.out.print(" + ");
        soma.getExpressaoDireita().aceita(this);
        System.out.print(")");
    }

    @Override
    public void imprimeSubtracao(Subtracao subtracao) {
        System.out.print("(");
        subtracao.getExpressaoEsquerda().aceita(this);
        System.out.print(" - ");
        subtracao.getExpressaoDireita().aceita(this);
        System.out.print(")");
    }

    @Override
    public void imprimeNumero(Numero numero) {
        System.out.print(numero.getNumero());
    }
}

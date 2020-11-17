package br.com.demo;

public class ImpressoraPreFixadaVisitor implements Visitor {

    @Override
    public void imprimeSoma(Soma soma) {
        System.out.print(" + ");

        System.out.print("(");
        soma.getExpressaoEsquerda().aceita(this);
        soma.getExpressaoDireita().aceita(this);
        System.out.print(")");
    }

    @Override
    public void imprimeSubtracao(Subtracao subtracao) {
        System.out.print(" - ");
        System.out.print("(");
        subtracao.getExpressaoEsquerda().aceita(this);
        subtracao.getExpressaoDireita().aceita(this);
        System.out.print(")");
    }

    @Override
    public void imprimeNumero(Numero numero) {
        System.out.print(numero.getNumero());
    }
}

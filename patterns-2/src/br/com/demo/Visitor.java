package br.com.demo;

public interface Visitor {

    void imprimeSoma(Soma soma);

    void imprimeSubtracao(Subtracao subtracao);

    void imprimeNumero(Numero numero);

}

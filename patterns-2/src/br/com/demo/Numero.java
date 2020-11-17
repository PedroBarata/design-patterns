package br.com.demo;

public class Numero implements Expressao {

    private int numero;

    public Numero(int numero) {
        this.numero = numero;
    }

    @Override
    public int avalia() {
        return this.numero;
    }

    public int getNumero() {
        return numero;
    }

    public void aceita(Visitor visitor) {
        visitor.imprimeNumero(this);
    }
}

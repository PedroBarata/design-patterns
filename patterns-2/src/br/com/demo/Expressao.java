package br.com.demo;

public interface Expressao {

    int avalia();

    void aceita(Visitor visitor);
}

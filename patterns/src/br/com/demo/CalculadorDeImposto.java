package br.com.demo;

public class CalculadorDeImposto {

    public void calcula(Orcamento orcamento, Imposto imposto) {
        double impostoCalculado = imposto.calcula(orcamento);
        System.out.println(impostoCalculado);
    }
}

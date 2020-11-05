package br.com.demo;

public class ISS implements Imposto {
    @Override
    public void calcula(Orcamento orcamento) {
        double icms = orcamento.getValor() * 0.06;
        System.out.println(icms);
    }
}

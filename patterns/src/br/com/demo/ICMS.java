package br.com.demo;

public class ICMS implements Imposto {

    @Override
    public void calcula(Orcamento orcamento) {
        double icms = orcamento.getValor() * 0.1;
        System.out.println(icms);
    }
}

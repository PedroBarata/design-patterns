package br.com.demo;

public abstract class TemplateDeImpostoCondicional implements Imposto {

    @Override
    public double calcula(Orcamento orcamento) {
        if(deveUsarTaxacaoMaxima(orcamento)) {
            return calculaTaxacaoMaxima(orcamento);
        } else {
            return calculaTaxacaoMinima(orcamento);
        }
    }
    public abstract boolean deveUsarTaxacaoMaxima(Orcamento orcamento);

    public abstract double calculaTaxacaoMinima(Orcamento orcamento);

    public abstract double calculaTaxacaoMaxima(Orcamento orcamento);


}

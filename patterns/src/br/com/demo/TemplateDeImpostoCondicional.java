package br.com.demo;

public abstract class TemplateDeImpostoCondicional extends Imposto {

    public TemplateDeImpostoCondicional() {}

    public TemplateDeImpostoCondicional(Imposto outroImposto) {
        super(outroImposto);
    }

    @Override
    public double calcula(Orcamento orcamento) {
        if (deveUsarTaxacaoMaxima(orcamento)) {
            return calculaTaxacaoMaxima(orcamento) + calculaOutroImposto(orcamento);
        } else {
            return calculaTaxacaoMinima(orcamento) + calculaOutroImposto(orcamento);
        }
    }

    public abstract boolean deveUsarTaxacaoMaxima(Orcamento orcamento);

    public abstract double calculaTaxacaoMinima(Orcamento orcamento);

    public abstract double calculaTaxacaoMaxima(Orcamento orcamento);


}

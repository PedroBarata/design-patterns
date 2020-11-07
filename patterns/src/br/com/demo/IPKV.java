package br.com.demo;

public class IPKV extends TemplateDeImpostoCondicional {

    public IPKV() {}

    public IPKV(Imposto outroImposto) {
        super(outroImposto);
    }

    @Override
    public boolean deveUsarTaxacaoMaxima(Orcamento orcamento) {
        return orcamento.getValor() > 500;
    }

    @Override
    public double calculaTaxacaoMinima(Orcamento orcamento) {
        return orcamento.getValor() * 0.03;
    }

    @Override
    public double calculaTaxacaoMaxima(Orcamento orcamento) {
        return orcamento.getValor() * 0.06;
    }
}

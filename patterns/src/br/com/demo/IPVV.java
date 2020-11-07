package br.com.demo;

public class IPVV extends TemplateDeImpostoCondicional {

    public boolean possuiAlgumItemAcimaDe100Reais(Orcamento orcamento) {
        return orcamento.getItens().stream().anyMatch(item -> item.getValor() > 100);
    }

    @Override
    public boolean deveUsarTaxacaoMaxima(Orcamento orcamento) {
        return possuiAlgumItemAcimaDe100Reais(orcamento) && orcamento.getValor() > 500;
    }

    @Override
    public double calculaTaxacaoMinima(Orcamento orcamento) {
        return orcamento.getValor() * 0.06;
    }

    @Override
    public double calculaTaxacaoMaxima(Orcamento orcamento) {
        return orcamento.getValor() * 0.1;
    }
}

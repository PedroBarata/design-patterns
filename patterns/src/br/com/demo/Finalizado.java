package br.com.demo;

public class Finalizado implements EstadoDeUmOrcamento {

    @Override
    public void aplicaDescontoExtra(Orcamento orcamento) {
        throw new RuntimeException("Orçamento já finalizado!");
    }

    @Override
    public void aprova(Orcamento orcamento) {
        throw new RuntimeException("Orçamento já finalizado!");
    }

    @Override
    public void reprova(Orcamento orcamento) {
        throw new RuntimeException("Orçamento já finalizado!");
    }

    @Override
    public void finaliza(Orcamento orcamento) {
        throw new RuntimeException("Orçamento já finalizado!");
    }
}
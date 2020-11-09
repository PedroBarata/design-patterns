package br.com.demo;

public class Aprovado implements EstadoDeUmOrcamento {

    private boolean descontoJaAplicado = false;

    @Override
    public void aplicaDescontoExtra(Orcamento orcamento) {
        if (!this.descontoJaAplicado) {
            orcamento.valor -= orcamento.valor * 0.02;
            this.descontoJaAplicado = true;
        } else {
            throw new RuntimeException("Desconto já aplicado!");
        }
    }

    @Override
    public void aprova(Orcamento orcamento) {
        throw new RuntimeException("Orçamento aprovado!");
    }

    @Override
    public void reprova(Orcamento orcamento) {
        throw new RuntimeException("Orçamento aprovado!");
    }

    @Override
    public void finaliza(Orcamento orcamento) {
        orcamento.estadoAtual = new Finalizado();
    }
}

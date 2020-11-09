package br.com.demo;

public class EmAprovacao implements EstadoDeUmOrcamento {

    private boolean descontoJaAplicado = false;

    @Override
    public void aplicaDescontoExtra(Orcamento orcamento) {
        if (!this.descontoJaAplicado) {
            orcamento.valor -= orcamento.valor * 0.05;
            this.descontoJaAplicado = true;
        } else {
            throw new RuntimeException("Desconto já aplicado!");
        }
    }

    @Override
    public void aprova(Orcamento orcamento) {
        orcamento.estadoAtual = new Aprovado();
    }

    @Override
    public void reprova(Orcamento orcamento) {
        orcamento.estadoAtual = new Reprovado();
    }

    @Override
    public void finaliza(Orcamento orcamento) {
        throw new RuntimeException("Orçamentos em aprovação não podem ser finalizados!");
    }
}

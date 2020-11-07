package br.com.demo;

public class DescontoAcimaDeQuinhentosReais implements Desconto {

    private Desconto proximoDesconto;

    @Override
    public double desconta(Orcamento orcamento) {
        if (orcamento.getValor() > 500.0) {
            return orcamento.getValor() * 0.07;
        } else {
            return this.proximoDesconto.desconta(orcamento);
        }
    }

    @Override
    public void setProximo(Desconto proximoDesconto) {
        this.proximoDesconto = proximoDesconto;
    }
}

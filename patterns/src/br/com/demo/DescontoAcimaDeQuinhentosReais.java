package br.com.demo;

public class DescontoAcimaDeQuinhentosReais implements Desconto {

    private Desconto proximoDesconto;

    public DescontoAcimaDeQuinhentosReais() {
        this.proximoDesconto = null;

    }
    public DescontoAcimaDeQuinhentosReais(Desconto proximoDesconto) {
        if (proximoDesconto != null) {
            this.proximoDesconto = proximoDesconto;
        }
    }

    @Override
    public double desconta(Orcamento orcamento) {
        if (orcamento.getValor() > 500.0) {
            return orcamento.getValor() * 0.07;
        } else if (proximoDesconto != null) {
            return this.proximoDesconto.desconta(orcamento);
        } else {
            return 0;
        }
    }

}

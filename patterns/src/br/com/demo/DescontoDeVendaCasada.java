package br.com.demo;

public class DescontoDeVendaCasada implements Desconto {
    private Desconto proximoDesconto;

    public DescontoDeVendaCasada() {
        this.proximoDesconto = null;
    }

    public DescontoDeVendaCasada(Desconto proximoDesconto) {
        if(proximoDesconto != null) {
            this.proximoDesconto = proximoDesconto;
        }
    }

    @Override
    public double desconta(Orcamento orcamento) {
        if (orcamento.contemItemDeNome("LAPIS") && orcamento.contemItemDeNome("CANETA")) {
            return orcamento.getValor() * 0.05;
        } else if (proximoDesconto != null) {
            return this.proximoDesconto.desconta(orcamento);
        } else {
            return 0;
        }
    }
}

package br.com.demo;

public class DescontoComMaisDeCincoItens implements Desconto {

    private Desconto proximoDesconto;

    public DescontoComMaisDeCincoItens() {
        this.proximoDesconto = null;
    }

    public DescontoComMaisDeCincoItens(Desconto proximoDesconto) {
        this.proximoDesconto = proximoDesconto;
    }


    @Override
    public double desconta(Orcamento orcamento) {
        if (orcamento.getItens().size() > 5) {
            return orcamento.getValor() * 0.1;
        } else if (proximoDesconto != null) {
            return this.proximoDesconto.desconta(orcamento);
        } else {
            return 0;
        }
    }
}

package Acoplamento;

import java.util.List;

public class GeradorDeNotaFiscal {
    private List<AcaoAposGerarNF> acoesAposGerarNF;

    public GeradorDeNotaFiscal(List<AcaoAposGerarNF> acoesAposGerarNF) {
        this.acoesAposGerarNF = acoesAposGerarNF;
    }

    public NotaFiscal gera(Fatura fatura) {

        double valor = fatura.getValorMensal();

        NotaFiscal nf = new NotaFiscal(valor, impostoSimplesSobreO(valor));

        acoesAposGerarNF.forEach(acao -> acao.executa(nf));

        return nf;
    }

    private double impostoSimplesSobreO(double valor) {
        return valor * 0.06;
    }
}

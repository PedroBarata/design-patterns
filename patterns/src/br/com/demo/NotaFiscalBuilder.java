package br.com.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaces Fluentes
 */
public class NotaFiscalBuilder {

    private String cnpj;
    private String razaoSocial;
    private double valorBruto;
    private Calendar dataDaEmissao;
    private String observacoes;
    private double impostos;
    private List<ItemDaNota> notaList = new ArrayList<ItemDaNota>();
    private List<AcaoAposGerarNotaFiscal> todasAsAcoesAposGerarNotaFiscal;

    public NotaFiscalBuilder(List<AcaoAposGerarNotaFiscal> acoes) {
        this.todasAsAcoesAposGerarNotaFiscal = acoes;
    }

   /* public void adicionaAcao(AcaoAposGerarNotaFiscal acao) {
        this.todasAsAcoesAposGerarNotaFiscal.add(acao);
    }*/

    /**
     * Usando method chain (retorna o próprio builder)
     */
    public NotaFiscalBuilder comCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public NotaFiscalBuilder comNome(String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public NotaFiscalBuilder comObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }

    public NotaFiscalBuilder naData(String dataString) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formato.parse(dataString));
        this.dataDaEmissao = calendar;
        return this;
    }

    public NotaFiscalBuilder comItem(ItemDaNota item) {
        this.notaList.add(item);
        this.valorBruto += item.getValor();
        this.impostos += item.getValor() * 0.05;
        return this;
    }

    public NotaFiscal buildNotaFiscal() {
        NotaFiscal nf = new NotaFiscal(
                this.cnpj,
                this.razaoSocial,
                this.valorBruto,
                this.dataDaEmissao,
                this.observacoes,
                this.notaList,
                this.impostos
        );

        todasAsAcoesAposGerarNotaFiscal.forEach(acaoAposGerarNotaFiscal -> {
            acaoAposGerarNotaFiscal.executa(nf);
        });

        return nf;
    }

}

package br.com.demo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TesteDoPadraoBuilder {

    /**
     * Exemplo de utilização do padrão Builder,
     * usando uma classe complexa (NotaFiscal) e abstraindo as regras
     * de negócio e criação para o NotaFiscalBuilder
     */
    public static void main(String[] args) throws ParseException {
        List<AcaoAposGerarNotaFiscal> acoes = new ArrayList<>();
        NotaFiscalBuilder builder = new NotaFiscalBuilder(acoes)
                .comCnpj("1234567")
                .comItem(new ItemDaNota("Item 1", 300.0))
                .comItem(new ItemDaNota("Item 2", 200.0))
                .comItem(new ItemDaNota("Item 3", 500.0))
                .comNome("Teste")
                .comObservacoes("observacoes")
                .naData("10/10/2020");

        NotaFiscal nf = builder.buildNotaFiscal();
        System.out.println(nf.getValorBruto());
        System.out.println(nf.getDataDaEmissao().getTime());
    }
}

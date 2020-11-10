package br.com.demo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TesteDoObserver {

    /**
     * Exemplo de utilização do padrão Observer,
     * usando os métodos "executa" de cada uma das
     * implementações da interface abaixo
     */
    public static void main(String[] args) throws ParseException {
        List<AcaoAposGerarNotaFiscal> acoes = new ArrayList<>();
        acoes.add(new EnviadorDeEmail());
        acoes.add(new EnviadorDeSms());
        acoes.add(new NotaFiscalDAO());
        acoes.add(new Impressora());
        acoes.add(new Multiplicador(2));
        NotaFiscalBuilder builder = new NotaFiscalBuilder(acoes);


        NotaFiscal nf = builder.comCnpj("1234567")
                .comItem(new ItemDaNota("Item 1", 300.0))
                .comItem(new ItemDaNota("Item 2", 200.0))
                .comItem(new ItemDaNota("Item 3", 500.0))
                .comNome("Teste")
                .comObservacoes("observacoes")
                .naData("10/12/2020").buildNotaFiscal();

        System.out.println(nf.getValorBruto());
        System.out.println(nf.getDataDaEmissao().getTime());
    }
}

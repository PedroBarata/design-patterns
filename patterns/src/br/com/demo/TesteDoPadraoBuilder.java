package br.com.demo;

public class TesteDoPadraoBuilder {

    /**
     * Exemplo de utilização do padrão Builder,
     * usando uma classe complexa (NotaFiscal) e abstraindo as regras
     * de negócio e criação para o NotaFiscalBuilder
     */
    public static void main(String[] args) {
        NotaFiscalBuilder builder = new NotaFiscalBuilder()
                .comCnpj("1234567")
                .comItem(new ItemDaNota("Item 1", 300.0))
                .comItem(new ItemDaNota("Item 2", 200.0))
                .comItem(new ItemDaNota("Item 3", 500.0))
                .comNome("Teste")
                .comObservacoes("observacoes")
                .dataAtual();

        NotaFiscal nf = builder.buildNotaFiscal();
        System.out.println(nf.getValorBruto());
    }
}

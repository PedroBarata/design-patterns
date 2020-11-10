package br.com.demo;

public class Impressora implements AcaoAposGerarNotaFiscal {
    @Override
    public void executa(NotaFiscal nf) {
        System.out.println("Imprimi a nota!");
    }
}

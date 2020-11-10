package br.com.demo;

public class NotaFiscalDAO implements AcaoAposGerarNotaFiscal {
    @Override
    public void executa(NotaFiscal nf) {
        System.out.println("Salvei no banco!");
    }
}

package br.com.demo;

public class EnviadorDeSms implements AcaoAposGerarNotaFiscal {
    @Override
    public void executa(NotaFiscal nf) {
        System.out.println("Enviei SMS!");
    }
}

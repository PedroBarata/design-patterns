package br.com.demo;

public class EnviadorDeEmail implements AcaoAposGerarNotaFiscal {

    @Override
    public void executa(NotaFiscal nf) {
        System.out.println("Enviei Email!");
    }
}

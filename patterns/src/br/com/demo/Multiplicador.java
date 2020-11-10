package br.com.demo;

public class Multiplicador implements AcaoAposGerarNotaFiscal {

    private double fator;

    public Multiplicador(double fator) {
        this.fator = fator;
    }

    @Override
    public void executa(NotaFiscal nf) {
        System.out.println(nf.getValorBruto() * fator);
    }
}

package br.com.demo;

public abstract class Imposto {

    private Imposto outroImposto;

    public Imposto() {
    }

    public Imposto(Imposto outroImposto) {
        this.outroImposto = outroImposto;
    }

    abstract double calcula(Orcamento orcamento);

    double calculaOutroImposto(Orcamento orcamento) {
        if (outroImposto != null) {
            return this.outroImposto.calcula(orcamento);
        } else {
            return 0;
        }
    }
}

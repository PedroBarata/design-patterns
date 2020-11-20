package HerancaEComposicao;

public class ContaComum {

    private ManipuladorDeSaldo manipuladorDeSaldo;

    public ContaComum() {
        this.manipuladorDeSaldo = new ManipuladorDeSaldo();
    }

    public void deposita(double valor) {
        manipuladorDeSaldo.deposita(valor);
    }

    public void saca(double valor) {
        manipuladorDeSaldo.saca(valor);
    }

    public void rende() {
        manipuladorDeSaldo.rende(1.1);
    }

    public double getSaldo() {
        return manipuladorDeSaldo.getSaldo();
    }
}

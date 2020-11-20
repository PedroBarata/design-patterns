package HerancaEComposicao;

public class ContaDeEstudante {

    private int milhas;
    private ManipuladorDeSaldo manipuladorDeSaldo;

    public ContaDeEstudante() {
        this.manipuladorDeSaldo = new ManipuladorDeSaldo();
    }

    public void deposita(double valor) {
        manipuladorDeSaldo.deposita(valor);
        this.milhas += (int) valor;
    }

    public int getMilhas() {
        return milhas;
    }

}

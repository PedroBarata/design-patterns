package br.com.demo;

public class TesteDoPadraoFacadeESingleton {

    public static void main(String[] args) {

        EmpresaFacade facade = new EmpresaFacadeSingleton().getInstancia();
        Cliente cliente = facade.buscaClientePorCpf("1234");

        Fatura fatura = facade.emiteFatura(cliente, 5000.0);
    }
}

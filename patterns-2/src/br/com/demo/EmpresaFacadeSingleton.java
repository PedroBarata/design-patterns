package br.com.demo;

public class EmpresaFacadeSingleton {

    private static EmpresaFacade instancia;

    public EmpresaFacade getInstancia() {
        if (instancia == null) {
            return new EmpresaFacade();
        }
        return instancia;
    }
}

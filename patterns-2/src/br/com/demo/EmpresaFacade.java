package br.com.demo;

public class EmpresaFacade {

    public Cliente buscaClientePorCpf(String cpf) {
        return clienteDAO.buscaPorCpf(cpf);
    }

    public Fatura emiteFatura(Cliente cliente, double valor) {
        return fatura.emiteFatura(cliente, valor);
    }
}

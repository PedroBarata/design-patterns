package br.com.demo;

import java.util.Calendar;

public class Pedido {

    private String cliente;
    private Status status;
    private Double valor;
    private Calendar dataFinalizacao;

    public Pedido(String cliente, Double valor) {
        this.cliente = cliente;
        this.status = Status.NOVO;
        this.valor = valor;
    }

    public void paga() {
        this.status = Status.PAGO;
    }

    public void finaliza() {
        this.dataFinalizacao = Calendar.getInstance();
        this.status = Status.FINALIZADO;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

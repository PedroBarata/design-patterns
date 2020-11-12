package br.com.demo;

import java.util.Calendar;

public class Contrato {

    private Calendar data;
    private String cliente;
    private EstadoDoContrato estadoDoContrato;

    public Contrato(Calendar data, String cliente, EstadoDoContrato estadoDoContrato) {
        this.data = data;
        this.cliente = cliente;
        this.estadoDoContrato = estadoDoContrato;
    }

    public String getCliente() {
        return cliente;
    }

    public EstadoDoContrato getEstadoDoContrato() {
        return estadoDoContrato;
    }

    public Calendar getData() {
        return data;
    }

    public void avanca() {
        if (EstadoDoContrato.NOVO.equals(this.estadoDoContrato))
            this.estadoDoContrato = EstadoDoContrato.EM_PROCESSAMENTO;
        else if (EstadoDoContrato.EM_PROCESSAMENTO.equals(this.estadoDoContrato))
            this.estadoDoContrato = EstadoDoContrato.CONCLUIDO;
    }

    //-------------METODOS DO MEMENTO (MEMORIA)----------------------//
    public Estado salvaEstado() {
        return new Estado(new Contrato(this.data, this.cliente, this.estadoDoContrato));
    }

    public void restaura(Estado estado) {
        this.data = estado.getContrato().getData();
        this.cliente = estado.getContrato().getCliente();
        this.estadoDoContrato = estado.getContrato().getEstadoDoContrato();
    }

}



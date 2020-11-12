package br.com.demo;

import java.util.Calendar;

public class Estado {

    private Contrato contrato;
    private Calendar dataHoraPersistencia; //Data na qual foi salvo a alteração de estado no registro

    public Estado(Contrato contrato) {
        this.contrato = contrato;
        this.dataHoraPersistencia = Calendar.getInstance();
    }

    public Contrato getContrato() {
        return contrato;
    }

    public Calendar getDataHoraPersistencia() {
        return dataHoraPersistencia;
    }
}

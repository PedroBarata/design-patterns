package br.com.demo;

import java.util.Calendar;

public class TesteDoMemento {
    /**
     * Teste do padrão memento, onde temos uma lista de estados (histórico)
     * e podemos fazer um rollback ou algo do tipo no estado de um Contrato.
     */
    public static void main(String[] args) throws InterruptedException {
        Historico historico = new Historico();
        Contrato c1 = new Contrato(Calendar.getInstance(), "Pedro", EstadoDoContrato.NOVO);
        historico.adiciona(c1.salvaEstado());
        Thread.sleep(4000);

        System.out.println(
                historico.pega(0).getContrato().getEstadoDoContrato()
                        + "\n"
                        + historico.pega(0).getDataHoraPersistencia().getTime());
        c1.avanca();
        historico.adiciona(c1.salvaEstado());
        System.out.println(
                historico.pega(1).getContrato().getEstadoDoContrato()
                        + "\n"
                        + historico.pega(1).getDataHoraPersistencia().getTime());
        c1.avanca();
        historico.adiciona(c1.salvaEstado());
        c1.restaura(historico.pega(1));
        System.out.println(c1.getEstadoDoContrato());

    }
}

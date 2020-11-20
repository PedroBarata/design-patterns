package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {
    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private double mediaDosLances = 0.0;
    public void avalia(Leilao leilao) {
        for (Lance lance : leilao.getLances()) {
            if (lance.getValor() > maiorDeTodos) this.maiorDeTodos = lance.getValor();
            if (lance.getValor() < menorDeTodos) this.menorDeTodos = lance.getValor();

            mediaDosLances += lance.getValor();
        }
        if(!leilao.getLances().isEmpty())
        mediaDosLances = mediaDosLances / leilao.getLances().size();
    }

    public double getMaiorLance() {
        return maiorDeTodos;
    }

    public double getMenorLance() {
        return menorDeTodos;
    }

    public double getMediaDosLances() {
        return mediaDosLances;
    }
}

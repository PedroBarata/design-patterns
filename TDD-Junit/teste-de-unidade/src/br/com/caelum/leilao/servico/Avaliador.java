package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {
    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private double mediaDosLances = 0.0;
    private List<Lance> tresMaioresLances;

    public void avalia(Leilao leilao) {
        for (Lance lance : leilao.getLances()) {
            if (lance.getValor() > maiorDeTodos) this.maiorDeTodos = lance.getValor();
            if (lance.getValor() < menorDeTodos) this.menorDeTodos = lance.getValor();

            mediaDosLances += lance.getValor();
        }
        if(!leilao.getLances().isEmpty()) mediaDosLances = mediaDosLances / leilao.getLances().size();

        tresMaioresLances = new ArrayList<Lance>(leilao.getLances());
        Collections.sort(tresMaioresLances, (o1, o2) -> {
            if(o1.getValor() > o2.getValor()) return -1;
            if(o1.getValor() < o2.getValor()) return 1;
            return 0;
        });

        tresMaioresLances = tresMaioresLances.subList(0, Math.min(tresMaioresLances.size(), 3));

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

    public List<Lance> getTresMaioresLances() {
        return tresMaioresLances;
    }
}

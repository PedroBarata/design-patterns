package br.com.caelum.leilao.dominio;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

    private String descricao;
    private List<Lance> lances;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<Lance>();
    }

    public void propoe(Lance lance) {
        if (this.getLances().isEmpty() || podeDarLance(lance)) {
            lances.add(lance);
        }
    }

    public void dobraLance(Usuario usuario) {
        Lance ultimo = ultimoLanceDo(usuario);
        if (ultimo != null) {
            propoe(new Lance(usuario, ultimo.getValor() * 2));
        }
    }

    private Lance ultimoLanceDo(Usuario usuario) {
        Lance ultimo = null;
        for (Lance l : getLances()) {
            if (usuario.equals(l.getUsuario())) ultimo = l;
        }
        return ultimo;
    }

    public boolean podeDarLance(Lance lance) {
        return !doisLancesSeguidosDoMesmoUsuario(lance) && totalDeLancesDo(lance.getUsuario()) < 5;
    }

    private int totalDeLancesDo(Usuario usuario) {
        int total = 0;
        for (Lance l : this.getLances())
            if (l.getUsuario().equals(usuario)) {
                total++;
            }
        return total;
    }


    private Lance ultimoLanceDado() {
        return this.getLances().get(this.getLances().size() - 1);
    }

    private boolean doisLancesSeguidosDoMesmoUsuario(Lance lance) {
        return lance.getUsuario().equals(ultimoLanceDado().getUsuario());
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Lance> getLances() {
        return Collections.unmodifiableList(lances);
    }


}

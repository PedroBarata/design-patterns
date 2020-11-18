package br.com.demo;

import java.util.ArrayList;
import java.util.List;

public class FilaDeTrabalho {
    private List<Comando> comandoList;

    public FilaDeTrabalho() {
        this.comandoList = new ArrayList<>();
    }

    public void adicionaComando(Comando comando) {
        this.comandoList.add(comando);
    }

    public void processa() {
        for (Comando comando : this.comandoList) {
            comando.executa();
        }
    }


}

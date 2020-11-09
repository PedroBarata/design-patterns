package br.com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {

    protected double valor;
    private List<Item> itens;
    protected EstadoDeUmOrcamento estadoAtual;
    protected boolean descontoJaAplicado;

    public Orcamento(double valor) {
        this.valor = valor;
        this.itens = new ArrayList<Item>();
        this.estadoAtual = new EmAprovacao();
        this.descontoJaAplicado = false;
    }

    public double getValor() {
        return valor;
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(this.itens);
    }

    public void addItem(String nome, double valor) {
        this.itens.add(new Item(nome, valor));
    }

    public boolean contemItemDeNome(String nomeDoItem) {
        for (Item item : itens) {
            if (item.getNome().equals(nomeDoItem)) return true;
        }
        return false;
    }

    public void aplicaDescontoExtra() {
        estadoAtual.aplicaDescontoExtra(this);
    }

    public void aprova() {
        estadoAtual.aprova(this);
    }

    public void reprova() {
        estadoAtual.reprova(this);
    }

    public void finaliza() {
        estadoAtual.finaliza(this);
    }

}

package br.com.demo;

public interface Desconto {

    double desconta(Orcamento orcamento);

    void setProximo(Desconto proximoDesconto);
}

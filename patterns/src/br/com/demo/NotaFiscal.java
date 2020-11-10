package br.com.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscal {

    private String cnpj;
    private String razaoSocial;
    private double valorBruto;
    private Calendar dataDaEmissao;
    private String observacoes;
    private List<ItemDaNota> notaList;

    public NotaFiscal(String cnpj, String razaoSocial, double valorBruto, Calendar dataDaEmissao, String observacoes, List<ItemDaNota> notaList) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.valorBruto = valorBruto;
        this.dataDaEmissao = dataDaEmissao;
        this.observacoes = observacoes;
        this.notaList = notaList;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public Calendar getDataDaEmissao() {
        return dataDaEmissao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public List<ItemDaNota> getNotaList() {
        return notaList;
    }
}

package br.com.demo;

public class RaizQuadrada implements Expressao {

    private Expressao expressao;

    public RaizQuadrada(Expressao expressao) {
        this.expressao = expressao;
    }

    @Override
    public int avalia() {
        int resultadoExpressao = expressao.avalia();
        return (int) Math.sqrt(resultadoExpressao);
    }

    @Override
    public void aceita(Visitor visitor) {
    }
}

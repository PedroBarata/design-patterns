package br.com.demo;

public class TesteDoPadraoCommand {
    /**
     * Padrao command: Criamos uma lista de comandos
     * a serem executados no futuro, neste caso, criamos
     * uma série de pedidos e de comandos a serem executados
     * nesses pedidos;
     * */

    public static void main(String[] args) {
        Pedido pedido1 = new Pedido("Pedro", 150.00);
        Pedido pedido2 = new Pedido("Marcelo", 350.00);

        FilaDeTrabalho filaDeTrabalho = new FilaDeTrabalho();
        filaDeTrabalho.adicionaComando(new PagaPedido(pedido1));
        filaDeTrabalho.adicionaComando(new PagaPedido(pedido2));
        filaDeTrabalho.adicionaComando(new ConcluiPedido(pedido1));

        filaDeTrabalho.processa();
    }
}

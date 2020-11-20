package Acoplamento;

public class NotaFiscalDao implements AcaoAposGerarNF {

    @Override
    public void executa(NotaFiscal nf) {
        System.out.println("salva nf no banco");
    }
}

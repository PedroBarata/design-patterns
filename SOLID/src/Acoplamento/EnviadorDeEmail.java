package Acoplamento;

public class EnviadorDeEmail implements AcaoAposGerarNF {

    @Override
    public void executa(NotaFiscal nf) {
        System.out.println("envia email da nf " + nf.getId());
    }
}
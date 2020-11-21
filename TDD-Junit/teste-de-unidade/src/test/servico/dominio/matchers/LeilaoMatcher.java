package test.servico.dominio.matchers;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import jdk.jfr.Description;

public class LeilaoMatcher extends TypeSafeMatcher<Leilao> {
    /**
     * Precisamos sobrescrever dois métodos: boolean matchesSafely(Leilao item) e void describeTo(Description description).
     * <p>
     * Para receber o Lance que procuraremos dentro do Leilão, criaremos um construtor nesse matcher:
     */
    private final Lance lance;

    public LeilaoMatcher(Lance lance) {
        this.lance = lance;
    }

    /*Retorna verdadeiro ou falso caso o leilao exista*/
    @Override
    protected boolean matchesSafely(Leilao item) {
        return item.getLances().contains(lance);
    }

    public void describeTo(Description description) {
        description.appendText("leilao com lance " + lance.getValor());
    }

    /*Metodo que instanciará o matcher nos testes*/
    public static Matcher<Leilao> temUmLance(Lance lance) {
        return new LeilaoMatcher(lance);
    }

    /*Com isso, basta passarmos assertThat(leilao, temUmLance(lance));*/
}

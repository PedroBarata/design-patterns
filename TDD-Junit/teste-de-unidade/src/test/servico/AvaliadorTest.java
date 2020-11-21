package test.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.servico.dominio.builder.CriadorDeLeilao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AvaliadorTest {

    private Avaliador leiloeiro;

    @BeforeEach
    public void setUp() {
        this.leiloeiro = new Avaliador();
    }

    @AfterEach
    public void finaliza() {
        System.out.println("fim");
    }

    @Test
    public void deveEntenderAOrdemDosLancesOrdemCrescente() {
        //parte 1: cenario
        Usuario joao = new Usuario("joao");
        Usuario jose = new Usuario("jose");
        Usuario maria = new Usuario("maria");

        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(maria, 250.0));
        leilao.propoe(new Lance(jose, 350.0));
        leilao.propoe(new Lance(joao, 450.0));

        //parte 2: executamos acoes
        leiloeiro.avalia(leilao);

        //parte 3: Validacao
        double menorLanceEsperado = 250.0;
        double maiorLanceEsperado = 450.0;
        double mediaDosLances = 350.0;
        assertEquals(menorLanceEsperado, leiloeiro.getMenorLance(), 0.0001);
        assertEquals(maiorLanceEsperado, leiloeiro.getMaiorLance(), 0.0001);
        //assertEquals(mediaDosLances, leiloeiro.getMediaDosLances(), 0.0001);
    }

    @Test
    public void deveEntenderApenasUmLance() {
        //parte 1: cenario
        Usuario joao = new Usuario("joao");

        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(joao, 450.0));

        //parte 2: executamos acoes
        leiloeiro.avalia(leilao);

        //parte 3: Validacao
        double menorLanceEsperado = 450.0;
        double maiorLanceEsperado = 450.0;
        double mediaDosLances = 450.0;
        assertEquals(menorLanceEsperado, leiloeiro.getMenorLance(), 0.0001);
        assertEquals(maiorLanceEsperado, leiloeiro.getMaiorLance(), 0.0001);
        //assertEquals(mediaDosLances, leiloeiro.getMediaDosLances(), 0.0001);
    }

    @Test
    public void deveRetornarOsTresMaiores() {
        Usuario joao = new Usuario("joao");
        Usuario jose = new Usuario("jose");
        Usuario maria = new Usuario("maria");

        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(maria, 300.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(joao, 700.0));
        leilao.propoe(new Lance(joao, 1000.0));

        //parte 2: executamos acoes
        leiloeiro.avalia(leilao);

        //parte 3: Validacao
        double menorLanceEsperado = 300.0;
        double maiorLanceEsperado = 1000.0;

        assertEquals(3, leiloeiro.getTresMaiores().size());
       // assertEquals(1000.0, leiloeiro.getTresMaiores().get(0).getValor());
        assertEquals(700.0, leiloeiro.getTresMaiores().get(1).getValor());
        assertEquals(400.0, leiloeiro.getTresMaiores().get(2).getValor());

        assertEquals(menorLanceEsperado, leiloeiro.getMenorLance(), 0.0001);
        assertEquals(maiorLanceEsperado, leiloeiro.getMaiorLance(), 0.0001);
    }

    @Test
    public void deveRetornarOsCincoMaiores() {
        Usuario joao = new Usuario("joao");
        Usuario jose = new Usuario("jose");
        Usuario maria = new Usuario("maria");

        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(maria, 300.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(joao, 700.0));
        leilao.propoe(new Lance(joao, 1000.0));
        leilao.propoe(new Lance(joao, 3000.0));
        //parte 2: executamos acoes
        leiloeiro.avalia(leilao);

        //parte 3: Validacao
        assertEquals(3, leiloeiro.getTresMaiores().size());
       // assertEquals(3000.0, leiloeiro.getTresMaiores().get(0).getValor());
        assertEquals(1000.0, leiloeiro.getTresMaiores().get(1).getValor());
        assertEquals(700.0, leiloeiro.getTresMaiores().get(2).getValor());

    }

    @Test
    public void deveRetornarOsDoisMaiores() {
        Usuario joao = new Usuario("joao");
        Usuario jose = new Usuario("jose");

        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(joao, 700.0));

        //parte 2: executamos acoes
        leiloeiro.avalia(leilao);

        //parte 3: Validacao
        assertEquals(2, leiloeiro.getTresMaiores().size());
        assertEquals(700.0, leiloeiro.getTresMaiores().get(0).getValor());
        assertEquals(400.0, leiloeiro.getTresMaiores().get(1).getValor());
    }

    @Test
    public void deveRetornarListaVazia() {
        Leilao leilao = new Leilao("Playstation");


        //parte 2: executamos acoes
        leiloeiro.avalia(leilao);

        //parte 3: Validacao
        assertEquals(0, leiloeiro.getTresMaiores().size());
    }

    @Test
    public void naoAvaliamosLeiloesSemLances() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation").constroi();
        /*JUnit 5, no 4- é @Test(expected = throwable.class)*/
        assertThrows(RuntimeException.class, () -> {
            leiloeiro.avalia(leilao);
        });
    }
}
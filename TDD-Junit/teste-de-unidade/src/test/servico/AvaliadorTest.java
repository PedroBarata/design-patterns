package test.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AvaliadorTest {

    @Test
    public void deveEntenderAOrdemDosLances() {
        //parte 1: cenario
        Usuario joao = new Usuario("joao");
        Usuario jose = new Usuario("jose");
        Usuario maria = new Usuario("maria");

        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(joao, 450.0));
        leilao.propoe(new Lance(jose, 350.0));
        leilao.propoe(new Lance(maria, 250.0));

        //parte 2: executamos acoes
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        //parte 3: Validacao
        double menorLanceEsperado = 250.0;
        double maiorLanceEsperado = 450.0;
        double mediaDosLances = 350.0;
        Assertions.assertEquals(menorLanceEsperado, leiloeiro.getMenorLance(), 0.0001);
        Assertions.assertEquals(maiorLanceEsperado, leiloeiro.getMaiorLance(), 0.0001);
        Assertions.assertEquals(mediaDosLances, leiloeiro.getMediaDosLances(), 0.0001);
    }
}
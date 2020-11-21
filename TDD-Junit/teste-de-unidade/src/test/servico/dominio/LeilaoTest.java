package test.servico.dominio;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeilaoTest {

    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
        Usuario joao = new Usuario("joao");

        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(joao, 450.0));

        assertEquals(1, leilao.getLances().size());
        assertEquals(250.0, leilao.getLances().get(0).getValor());

    }

    @Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
        Usuario joao = new Usuario("joao");
        Usuario jose = new Usuario("jose");

        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 450.0));

        leilao.propoe(new Lance(joao, 500.0));
        leilao.propoe(new Lance(jose, 600.0));

        leilao.propoe(new Lance(joao, 700.0));
        leilao.propoe(new Lance(jose, 1000.0));

        leilao.propoe(new Lance(joao, 800.0));
        leilao.propoe(new Lance(jose, 2000.0));

        leilao.propoe(new Lance(joao, 1400.0));
        leilao.propoe(new Lance(jose, 3000.0));

        //Nao pode aceitar
        leilao.propoe(new Lance(joao, 5000.0));

        assertEquals(10, leilao.getLances().size());
        assertEquals(250.0, leilao.getLances().get(0).getValor());
        assertEquals(450.0, leilao.getLances().get(1).getValor());
        assertEquals(500.0, leilao.getLances().get(2).getValor());
        assertEquals(600.0, leilao.getLances().get(3).getValor());
        assertEquals(700.0, leilao.getLances().get(4).getValor());
        assertEquals(1000.0, leilao.getLances().get(5).getValor());
        assertEquals(800.0, leilao.getLances().get(6).getValor());
        assertEquals(2000.0, leilao.getLances().get(7).getValor());
        assertEquals(1400.0, leilao.getLances().get(8).getValor());
        assertEquals(3000.0, leilao.getLances().get(9).getValor());

    }

    @Test
    public void deveDobrarUmLanceDeUmUsuario() {
        Usuario joao = new Usuario("joao");
        Usuario jose = new Usuario("jose");

        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 5000.0));

        leilao.dobraLance(joao);
        assertEquals(3, leilao.getLances().size());
        assertEquals(250.0 * 2, leilao.getLances().get(leilao.getLances().size() - 1).getValor());
    }

    @Test
    public void naoDeveCriarUmLanceDeUmUsuario() {
        Usuario joao = new Usuario("joao");

        Leilao leilao = new Leilao("Playstation");


        leilao.dobraLance(joao);
        assertEquals(0, leilao.getLances().size());
    }

}
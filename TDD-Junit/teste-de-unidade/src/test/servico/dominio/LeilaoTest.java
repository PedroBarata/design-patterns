package test.servico.dominio;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.servico.dominio.builder.CriadorDeLeilao;

import static org.junit.jupiter.api.Assertions.*;

class LeilaoTest {

    private Usuario joao;
    private Usuario jose;

    @BeforeEach
    public void criaAvaliadores() {
        this.joao = new Usuario("joao");
        this.jose = new Usuario("jose");
    }

    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {

        Leilao leilao = new CriadorDeLeilao()
                .para("Playstation")
                .lance(joao, 250.0)
                .lance(joao, 450.0).constroi();


        assertEquals(1, leilao.getLances().size());
        assertEquals(250.0, leilao.getLances().get(0).getValor());

    }

    @Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
        Leilao leilao = new CriadorDeLeilao()
                .para("Playstation")
                .lance(joao, 250.0)
                .lance(jose, 450.0)
                .lance(joao, 500.0)
                .lance(jose, 600.0)
                .lance(joao, 700.0)
                .lance(jose, 1000.0)
                .lance(joao, 800.0)
                .lance(jose, 2000.0)
                .lance(joao, 1400.0)
                .lance(jose, 3000.0)
                .lance(joao, 5000.0)
                .constroi();

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
        Leilao leilao = new Leilao("Playstation");

        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 5000.0));

        leilao.dobraLance(joao);
        assertEquals(3, leilao.getLances().size());
        assertEquals(250.0 * 2, leilao.getLances().get(leilao.getLances().size() - 1).getValor());
    }

    @Test
    public void naoDeveCriarUmLanceDeUmUsuario() {
        Leilao leilao = new Leilao("Playstation");


        leilao.dobraLance(joao);
        assertEquals(0, leilao.getLances().size());
    }

}
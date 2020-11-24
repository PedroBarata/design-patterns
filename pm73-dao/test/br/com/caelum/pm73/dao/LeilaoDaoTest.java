package br.com.caelum.pm73.dao;

import br.com.caelum.pm73.dominio.Leilao;
import br.com.caelum.pm73.dominio.Usuario;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeilaoDaoTest {
    private Session session;
    private UsuarioDao usuarioDao;
    private LeilaoDao leilaoDao;

    @Before
    public void antes() {
        session = new CriadorDeSessao().getSession();
        session.beginTransaction();

        usuarioDao = new UsuarioDao(session);
        leilaoDao = new LeilaoDao(session);
    }

    @After
    public void depois() {
        session.getTransaction().rollback();
        session.close();
    }

    @Test
    public void deveRetornarTotalDeLeiloesAtivos() {
        //cenario
        Usuario mauricio = new Usuario("mauricio", "mauricio@mauricio.com.br");

        Leilao leilao = new Leilao("Geladeira", 1500.0, mauricio, true);
        Leilao encerrado = new Leilao("Torradeira", 100.0, mauricio, true);
        encerrado.encerra();
        //acoes
        leilaoDao.salvar(leilao);
        leilaoDao.salvar(encerrado);
        usuarioDao.salvar(mauricio);
        long total = leilaoDao.total();

        //validacoes
        Assert.assertEquals(1L, total);
    }

    @Test
    public void deveRetornarNenhumLeilaoAtivo() {
        //cenario
        Usuario mauricio = new Usuario("mauricio", "mauricio@mauricio.com.br");

        Leilao leilao = new Leilao("Geladeira", 1500.0, mauricio, true);
        Leilao encerrado = new Leilao("Torradeira", 100.0, mauricio, true);
        encerrado.encerra();
        leilao.encerra();
        //acoes
        leilaoDao.salvar(leilao);
        leilaoDao.salvar(encerrado);
        usuarioDao.salvar(mauricio);
        long total = leilaoDao.total();

        //validacoes
        Assert.assertEquals(0L, total);
    }
}

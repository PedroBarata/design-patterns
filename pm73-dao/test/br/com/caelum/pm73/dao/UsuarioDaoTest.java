package br.com.caelum.pm73.dao;

import br.com.caelum.pm73.dominio.Usuario;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioDaoTest {


    @Test
    public void deveEncontrarUsuarioPorNomeEEmailMockado() {
        Session session = new CriadorDeSessao().getSession();

        UsuarioDao usuarioDao = new UsuarioDao(session);

        usuarioDao.salvar(new Usuario("Joao", "joao@dasilva.com.br"));

        Usuario usuario = usuarioDao.porNomeEEmail("Joao", "joao@dasilva.com.br");

        Assert.assertEquals("Joao", usuario.getNome());
        Assert.assertEquals("joao@dasilva.com.br", usuario.getEmail());
        session.close();
    }

    @Test
    public void deveRetornarNuloUsuarioPorNomeEEmailMockado() {
        Session session = new CriadorDeSessao().getSession();

        UsuarioDao usuarioDao = new UsuarioDao(session);

        Usuario usuario = usuarioDao.porNomeEEmail("Teste", "teste@teste.com.br");

        Assert.assertNull(usuario);
        session.close();
    }

    @Test
    public void deveDeletarOUsuario() {
        Session session = new CriadorDeSessao().getSession();
        Usuario joao = new Usuario("Joao", "joao@dasilva.com.br");
        UsuarioDao usuarioDao = new UsuarioDao(session);
        usuarioDao.salvar(joao);
        usuarioDao.deletar(joao);

        /*IMPORTANTE!!*/
        session.flush();
        session.clear();

        Usuario deletado = usuarioDao.porNomeEEmail("Joao", "joao@dasilva.com.br");
        Assert.assertNull(deletado);
        session.close();
    }

    @Test
    public void deveAlterarUmUsuario() {
        Session session = new CriadorDeSessao().getSession();
        UsuarioDao usuarioDao = new UsuarioDao(session);

        Usuario usuario =
                new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

        usuarioDao.salvar(usuario);

        usuario.setNome("João da Silva");
        usuario.setEmail("joao@silva.com.br");

        usuarioDao.atualizar(usuario);

        session.flush();

        Usuario novoUsuario =
                usuarioDao.porNomeEEmail("João da Silva", "joao@silva.com.br");
        Assert.assertNotNull(novoUsuario);
        System.out.println(novoUsuario);

        Usuario usuarioInexistente =
                usuarioDao.porNomeEEmail("Mauricio Aniche", "mauricio@aniche.com.br");
        Assert.assertNull(usuarioInexistente);

    }
}

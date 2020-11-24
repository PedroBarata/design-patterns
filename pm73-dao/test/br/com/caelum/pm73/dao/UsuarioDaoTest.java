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
}

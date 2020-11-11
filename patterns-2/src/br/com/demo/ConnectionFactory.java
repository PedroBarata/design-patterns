package br.com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Padrao factory, onde cria uma conexao,
 * ou seja, a alteração é pontual caso
 * algum desses valores for alterado
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            Connection conexao;
            String tipoBanco = System.getenv("tipoBanco");
            if ("mysql".equals(tipoBanco)) {
                conexao = DriverManager.getConnection("jdbc://mysql/localhost...", "root", "1234");
            } else {
                conexao = DriverManager.getConnection("jdbc://postgres/localhost...", "root", "1234");
            }
            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

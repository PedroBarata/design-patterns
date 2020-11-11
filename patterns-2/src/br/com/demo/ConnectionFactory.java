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
            Connection c = DriverManager.getConnection("jdbc://mysql/localhost...", "root", "1234");
            return c;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables.getCause());
        }
    }
}

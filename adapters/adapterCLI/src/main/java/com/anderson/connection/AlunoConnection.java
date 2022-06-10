package com.anderson.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AlunoConnection {
    String url = "jdbc:postgresql://localhost:5432/ALUNO";
    String user = "postgres";
    String password = "postgres";

    public Connection connection(){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

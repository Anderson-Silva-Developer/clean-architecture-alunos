package com.anderson.connection;

import java.sql.*;

public class AlunoConnection {
    String url = "jdbc:postgresql://localhost:5432/ALUNO";
    String user = "postgres";
    String password = "postgres";


    public Connection connection(){
        try{

            Connection conn= DriverManager.getConnection(url, user, password);
            System.out.println(conn.isClosed());

            return conn;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void CloseConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        try { rs.close();} catch (Exception e) { throw new RuntimeException(e); }
        try { ps.close();} catch (Exception e) { throw new RuntimeException(e); }
        try { conn.close();} catch (Exception e) {  throw new RuntimeException(e); }
    }
}

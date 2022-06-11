package com.anderson.repository;

import com.anderson.connection.AlunoConnection;
import com.anderson.entities.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOCLI {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private final String SELECT_ALL_QUERY = "select *from aluno";
    private final String SELECT_FINDBYID_QUERY = "select *from aluno where id= ?";
    private final String SELECT_FINDBYMATRICULA_QUERY = "select *from aluno where matricula=?";
    private final String INSERT_QUERY = "INSERT INTO aluno(nome,matricula) VALUES(?,?)";
    AlunoConnection connectionDAO = new AlunoConnection();

    public Aluno createAluno(Aluno aluno) {
        try {
            conn = connectionDAO.connection();
            ps = conn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getMatricula());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            Aluno newaluno;
            if (rs.next()) {
                Long id = rs.getLong("id");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                aluno = new Aluno.AlunoBuilder()
                        .id(id)
                        .nome(nome)
                        .matricula(matricula)
                        .build();
            }
            return aluno;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionDAO.CloseConnection(conn, ps, rs);
        }

    }

    public Aluno findByIdAluno(Long findid) {
        try {
            conn = connectionDAO.connection();
            ps = conn.prepareStatement(SELECT_FINDBYID_QUERY);
            ps.setLong(1, findid);
            rs = ps.executeQuery();
            Aluno findAluno = null;
            while (rs.next()) {
                Long id = rs.getLong("id");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                findAluno = new Aluno.AlunoBuilder()
                        .id(id)
                        .nome(nome)
                        .matricula(matricula)
                        .build();
            }
            return findAluno;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionDAO.CloseConnection(conn, ps, rs);
        }
    }

    public Aluno findByMatriculaAluno(String findmatricula) {

        try {
            conn = connectionDAO.connection();
            ps = conn.prepareStatement(SELECT_FINDBYMATRICULA_QUERY);
            ps.setString(1, findmatricula);
            rs = ps.executeQuery();
            Aluno findAluno = null;
            while (rs.next()) {
                Long id = rs.getLong("id");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                findAluno = new Aluno.AlunoBuilder()
                        .id(id)
                        .nome(nome)
                        .matricula(matricula)
                        .build();
            }

            return findAluno;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionDAO.CloseConnection(conn, ps, rs);
        }

    }

    public List<Aluno> getAllAlunos() throws SQLException {

        List<Aluno> alunoList = new ArrayList<>();
        try {
            conn = connectionDAO.connection();
            ps = conn.prepareStatement(SELECT_ALL_QUERY);
            rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                alunoList.add(
                        new Aluno.AlunoBuilder()
                                .id(id)
                                .nome(nome)
                                .matricula(matricula)
                                .build());
            }
            return alunoList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionDAO.CloseConnection(conn, ps, rs);

        }

    }


}

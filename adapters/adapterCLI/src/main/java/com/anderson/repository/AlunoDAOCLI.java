package com.anderson.repository;

import com.anderson.connection.AlunoConnection;
import com.anderson.entities.Aluno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOCLI {

    private static final String SELECT_ALL_QUERY = "select *from aluno";
    AlunoConnection connectionDAO=new AlunoConnection();

    public List<Aluno> getAllAlunos(){
        List<Aluno> alunoList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connectionDAO.connection().prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               Long id =resultSet.getLong("id");
               String matricula=resultSet.getString("matricula");
               String nome=resultSet.getString("nome");
               alunoList.add(
               new Aluno.AlunoBuilder()
                       .id(id)
                       .nome(nome)
                       .matricula(matricula)
                       .build());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunoList;
    }


}

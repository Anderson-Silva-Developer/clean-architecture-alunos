package com.anderson.repository;

import com.anderson.aluno.contract.useCaseRepository.AlunoRepository;
import com.anderson.entities.Aluno;

import java.sql.SQLException;
import java.util.*;

public class AlunoRepositoryCLI implements AlunoRepository {

    AlunoDAOCLI alunoDAOCLI=new AlunoDAOCLI();
    @Override
    public Aluno create(Aluno aluno) {
        return alunoDAOCLI.createAluno(aluno);
    }

    @Override
    public Optional<Aluno> findById(Long id) {
        return Optional.ofNullable(alunoDAOCLI.findByIdAluno(id));
    }

    @Override
    public Optional<Aluno> findByMatricula(String matricula) {

        return Optional.ofNullable(alunoDAOCLI.findByMatriculaAluno(matricula));
    }

    @Override
    public List<Aluno> findAllAlunos() {
        try {
            return alunoDAOCLI.getAllAlunos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

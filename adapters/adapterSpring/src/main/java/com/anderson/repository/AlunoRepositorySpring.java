package com.anderson.repository;

import com.anderson.aluno.contract.useCaseRepository.AlunoRepository;
import com.anderson.entities.Aluno;
import com.anderson.entity.AlunoEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class AlunoRepositorySpring implements AlunoRepository {

    @Autowired
    private AlunoDAO alunoDAO;
    @Override
    public Aluno create(Aluno aluno) {
        AlunoEntity newAlunoEntity = new AlunoEntity().fromAluno(aluno);
        return this.alunoDAO.save(newAlunoEntity).toAluno();

    }

    @Override
    public Optional<Aluno> findById(Long id) {
        Optional<AlunoEntity> alunoEntity= this.alunoDAO.findById(id);
        return alunoEntity.map(AlunoEntity::toAluno);
    }

    @Override
    public Optional<Aluno> findByMatricula(String matricula) {
        Optional<AlunoEntity> alunoEntity= this.alunoDAO.findByMatricula(matricula);
        return alunoEntity.map(AlunoEntity::toAluno);
    }

    @Override
    public List<Aluno> findAllAlunos() {
        return this.alunoDAO.findAll().stream().map(AlunoEntity::toAluno).collect(Collectors.toList());

    }
}

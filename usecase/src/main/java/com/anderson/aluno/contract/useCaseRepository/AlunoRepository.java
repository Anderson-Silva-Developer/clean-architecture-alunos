package com.anderson.aluno.contract.useCaseRepository;

import com.anderson.entities.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository {

    Aluno create(Aluno aluno);

    Optional<Aluno> findById(Long id);

    Optional<Aluno> findByMatricula(String matricula);

    List<Aluno> findAllAlunos();
}

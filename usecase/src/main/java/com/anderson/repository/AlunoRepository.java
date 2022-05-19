package com.anderson.repository;

import com.anderson.entities.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository {

    Aluno create(Aluno user);

    Optional<Aluno> findById(Long id);

    Optional<Aluno> findByMatricula(String matricula);

    List<Aluno> findAllAlunos();
}

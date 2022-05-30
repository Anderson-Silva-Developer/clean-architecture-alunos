package com.anderson.aluno.contract.useCaseService;

import com.anderson.entities.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoUsecaseService {
    public Aluno create(Aluno aluno);
    public Optional<Aluno> findById(Long id);
    Optional<Aluno> findByMatricula(String matricula);
    public List<Aluno> findAllAlunos();
}

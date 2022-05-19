package com.anderson;

import com.anderson.entities.Aluno;
import com.anderson.exception.FindAlunoException;
import com.anderson.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

public class FindAluno {

    private final AlunoRepository alunoRepository;

    public FindAluno(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Optional<Aluno> findById(Long id) {
        return Optional.ofNullable(this.alunoRepository.findById(id).orElseThrow(() -> new FindAlunoException("Aluno não encontrado")));

    }


    public Optional<Aluno> findByMatricula(String matricula) {
        return Optional.ofNullable(this.alunoRepository.findByMatricula(matricula).orElseThrow(() -> new FindAlunoException("Aluno não encontrado")));
    }


    public List<Aluno> findAllAlunos() {
        return this.alunoRepository.findAllAlunos();
    }
}

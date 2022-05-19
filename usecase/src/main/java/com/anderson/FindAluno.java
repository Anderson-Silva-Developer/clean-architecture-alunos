package com.anderson;

import com.anderson.entities.Aluno;
import com.anderson.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

public class FindAluno {

    private final AlunoRepository alunoRepository;

    public FindAluno(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Optional<Aluno> findById(Long id) {
        return this.alunoRepository.findById(id);
    }


    public Optional<Aluno> findByMatricula(String matricula) {
        return this.alunoRepository.findByMatricula(matricula);
    }


    public List<Aluno> findAllAlunos() {
        return this.alunoRepository.findAllAlunos();
    }
}

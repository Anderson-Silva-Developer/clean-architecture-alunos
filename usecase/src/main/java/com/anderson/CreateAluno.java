package com.anderson;

import com.anderson.entities.Aluno;
import com.anderson.exception.AlunoAlreadyExistsException;
import com.anderson.repository.AlunoRepository;
import com.anderson.validator.AlunoValidator;

public class CreateAluno {
    private final AlunoRepository alunoRepository;

    public CreateAluno(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    public Aluno create(Aluno aluno ){
        AlunoValidator.validateCreateAluno(aluno);
        if(this.alunoRepository.findByMatricula(aluno.getMatricula()).isPresent()
                || this.alunoRepository.findById(aluno.getId()).isPresent()){
            throw new AlunoAlreadyExistsException("O Aluno já existente!");
        }
        return this.alunoRepository.create(aluno);

    }
}

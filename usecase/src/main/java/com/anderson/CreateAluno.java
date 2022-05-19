package com.anderson;

import com.anderson.entities.Aluno;
import com.anderson.exception.AlunoAlreadyExistsException;
import com.anderson.repository.AlunoRepository;
import com.anderson.validator.AlunoValidator;

import java.text.Format;

public class CreateAluno {
    private final AlunoRepository alunoRepository;

    public CreateAluno(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    public Aluno create(Aluno aluno ){
        AlunoValidator.validateCreateAluno(aluno);
        if(this.alunoRepository.findByMatricula(aluno.getMatricula()).isPresent()){
            throw new AlunoAlreadyExistsException(aluno.getMatricula()+" já existe!");
        }
        return this.alunoRepository.create(aluno);

    }
}

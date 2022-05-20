package com.anderson;

import com.anderson.repository.AlunoRepository;
import com.anderson.repository.AlunoRepositorySpring;

public class SpringConfig {

    private final AlunoRepository alunoRepository = new AlunoRepositorySpring();


    public CreateAluno createAluno() {
        return new CreateAluno(alunoRepository);
    }

    public FindAluno findAluno() {
        return new FindAluno(alunoRepository);
    }

}

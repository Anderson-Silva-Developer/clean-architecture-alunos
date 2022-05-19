package com.anderson;

import com.anderson.repository.AlunoRepository;

public class ManualConfig {

    private final AlunoRepository alunoRepository = new InMemoryAlunoRepository();


    public CreateAluno createAluno() {
        return new CreateAluno(alunoRepository);
    }

    public FindAluno findAluno() {
        return new FindAluno(alunoRepository);
    }

}

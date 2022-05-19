package com.anderson;

import com.anderson.repository.AlunoRepository;

public class ManualConfig {

//    private final AlunoRepository alunoRepository = new CLIAlunoRepository();
private final AlunoRepository alunoRepository = new AlunoRepositoryCLI();

    public CreateAluno createAluno() {
        return new CreateAluno(alunoRepository);
    }

    public FindAluno findAluno() {
        return new FindAluno(alunoRepository);
    }

}

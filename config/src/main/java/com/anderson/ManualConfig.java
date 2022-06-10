package com.anderson;

import com.anderson.aluno.AlunoUsecaseServiceImpl;
import com.anderson.aluno.contract.useCaseRepository.AlunoRepository;

public class ManualConfig {

private final AlunoRepository alunoRepository;

    public ManualConfig(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    public AlunoUsecaseServiceImpl alunoUsecaseServiceImpl(){
        return new AlunoUsecaseServiceImpl(alunoRepository);
    }

}

package com.anderson.controller;


import com.anderson.aluno.AlunoUsecaseServiceImpl;
import com.anderson.model.AlunoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AlunoController {

    private  final AlunoUsecaseServiceImpl alunoUsecaseService;

    public AlunoController(AlunoUsecaseServiceImpl alunoUsecaseService) {
        this.alunoUsecaseService = alunoUsecaseService;
    }

    public AlunoDTO create(AlunoDTO alunoDTO){
        var aluno=alunoDTO.toAluno();
        return AlunoDTO.toAlunoDTO(this.alunoUsecaseService.create(aluno));
    }
    public AlunoDTO findByIdAluno(Long id){
        return AlunoDTO.toAlunoDTO(this.alunoUsecaseService.findById(id).get());
    }
    public AlunoDTO findByMatriculaAluno(String matricula){
        return AlunoDTO.toAlunoDTO(this.alunoUsecaseService.findByMatricula(matricula).get());
    }
    public List<AlunoDTO> findAllAlunos(){
        return this.alunoUsecaseService.findAllAlunos()
                .stream()
                .map(AlunoDTO::toAlunoDTO)
                .collect(Collectors.toList());
    }


}

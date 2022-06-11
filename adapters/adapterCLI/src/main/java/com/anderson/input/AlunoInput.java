package com.anderson.input;

import com.anderson.aluno.AlunoUsecaseServiceImpl;
import com.anderson.model.AlunoReqDTO;
import com.anderson.model.AlunoRespDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AlunoInput {

    private  final AlunoUsecaseServiceImpl alunoUsecaseService;

    public AlunoInput(AlunoUsecaseServiceImpl alunoUsecaseService) {
        this.alunoUsecaseService = alunoUsecaseService;
    }

    public AlunoRespDTO create(AlunoReqDTO alunoDTO){
        var aluno=alunoDTO.toAluno();
        return AlunoRespDTO.toAlunoDTO(this.alunoUsecaseService.create(aluno));
    }
    public AlunoRespDTO findByIdAluno(Long id){
        return AlunoRespDTO.toAlunoDTO(this.alunoUsecaseService.findById(id).get());
    }
    public AlunoRespDTO findByMatriculaAluno(String matricula){
        return AlunoRespDTO.toAlunoDTO(this.alunoUsecaseService.findByMatricula(matricula).get());
    }
    public List<AlunoRespDTO> findAllAlunos(){
        return this.alunoUsecaseService.findAllAlunos()
                .stream()
                .map(AlunoRespDTO::toAlunoDTO)
                .collect(Collectors.toList());
    }

}

package com.anderson.controller;

import com.anderson.CreateAluno;
import com.anderson.FindAluno;
import com.anderson.model.AlunoDTO;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoController {

    private  final CreateAluno createAluno;
    private final FindAluno findAluno;

    public AlunoController(CreateAluno createAluno, FindAluno findAluno) {
        this.createAluno = createAluno;
        this.findAluno = findAluno;
    }

    public AlunoDTO createAluno(AlunoDTO alunoDTO){
        var aluno=alunoDTO.toAluno();
        aluno.setId(new Date().getTime());
        return AlunoDTO.toAlunoDTO(createAluno.create(aluno));
    }
    public AlunoDTO findByIdAluno(Long id){
        return AlunoDTO.toAlunoDTO(findAluno.findById(id).get());
    }
    public AlunoDTO findByMatriculaAluno(String matricula){
        return AlunoDTO.toAlunoDTO(findAluno.findByMatricula(matricula).get());
    }
    public List<AlunoDTO> findAllAlunos(){
        return findAluno.findAllAlunos()
                .stream()
                .map(AlunoDTO::toAlunoDTO)
                .collect(Collectors.toList());
    }


}

package com.anderson.controller;

import com.anderson.model.AlunoReqDTO;
import com.anderson.model.AlunoRespDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class SpringAlunoController {
    private final AlunoController alunoController;

    public SpringAlunoController(AlunoController alunoController) {
        this.alunoController = alunoController;
    }

    @PostMapping
    public AlunoRespDTO createAluno(@RequestBody AlunoReqDTO alunoDTO){

        return this.alunoController.create(alunoDTO);
    }
    @GetMapping("/{id}")
    public AlunoRespDTO findByIdAluno(@PathVariable("id") Long id){
        return this.alunoController.findByIdAluno(id);

    }
    @GetMapping("/matricula/{matriculaAluno}")
    public AlunoRespDTO findByMatriculaAluno(@PathVariable("matriculaAluno") String matriculaAluno){
        return  this.alunoController.findByMatriculaAluno(matriculaAluno);
    }
    @GetMapping
    public List<AlunoRespDTO> findAllAlunos(){
        return this.alunoController.findAllAlunos();
    }
}

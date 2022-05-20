package com.anderson.controller;

import com.anderson.model.AlunoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class SpringAlunoController {
    private final AlunoController alunoController;

    public SpringAlunoController(AlunoController alunoController) {
        this.alunoController = alunoController;
    }

    @PostMapping
    public AlunoDTO createAluno(@RequestBody AlunoDTO alunoDTO){
        return this.alunoController.createAluno(alunoDTO);
    }
    @GetMapping("/{id}")
    public AlunoDTO findByIdAluno(@PathVariable("id") Long id){
        return this.alunoController.findByIdAluno(id);

    }
    @GetMapping("/matricula/{matriculaAluno}")
    public AlunoDTO findByMatriculaAluno( @PathVariable("matriculaAluno") String matriculaAluno){
        return  this.alunoController.findByMatriculaAluno(matriculaAluno);
    }
    @GetMapping
    public List<AlunoDTO> findAllAlunos(){
        return this.alunoController.findAllAlunos();
    }
}

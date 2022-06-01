package com.anderson.controller;

import com.anderson.model.AlunoReqDTO;
import com.anderson.model.AlunoRespDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AlunoRespDTO> createAluno(@RequestBody AlunoReqDTO alunoDTO){

        return  ResponseEntity.status(HttpStatus.CREATED).body(this.alunoController.create(alunoDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AlunoRespDTO> findByIdAluno(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.alunoController.findByIdAluno(id));

    }
    @GetMapping("/matricula/{matriculaAluno}")
    public ResponseEntity<AlunoRespDTO> findByMatriculaAluno(@PathVariable("matriculaAluno") String matriculaAluno){
        return  ResponseEntity.status(HttpStatus.OK).body(this.alunoController.findByMatriculaAluno(matriculaAluno));
    }
    @GetMapping
    public ResponseEntity<List<AlunoRespDTO>> findAllAlunos(){

        return ResponseEntity.status(HttpStatus.OK).body(this.alunoController.findAllAlunos());
    }
}

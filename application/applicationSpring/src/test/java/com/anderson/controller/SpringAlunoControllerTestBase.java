package com.anderson.controller;

import com.anderson.model.AlunoReqDTO;
import com.anderson.model.AlunoRespDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class SpringAlunoControllerTestBase {

    String erroFindByIdAlunoNaoEncontrado = "Aluno não encontrado";
    String erroCreateAlunoNull = "O Aluno não deve ser nulo";
    String erroCreateAlunoExistente = "O Aluno já existente!";
    String erroCreateAlunoNomeNull = "O nome do Aluno não deve ser nulo";
    String erroCreateAlunoMatriculaNull = "A matrícula do Aluno não deve ser nulo";

    public AlunoController alunoController;
    public AlunoReqDTO alunoReqDTO;
    public AlunoRespDTO alunoRespDTO;

    @BeforeEach
    void init() {
        alunoController = mock(AlunoController.class);
        alunoReqDTO=new AlunoReqDTO();
        alunoReqDTO.setNome("Aluno 01");
        alunoReqDTO.setMatricula("qwa123456");
        alunoRespDTO=new AlunoRespDTO();
        alunoRespDTO.setId(1L);
        alunoRespDTO.setNome("Aluno 01");
        alunoRespDTO.setMatricula("qwa123456");
    }

    @Test
    void createAluno() {
    }
}
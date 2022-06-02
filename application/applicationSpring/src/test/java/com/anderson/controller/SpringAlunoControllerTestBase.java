package com.anderson.controller;

import com.anderson.model.AlunoReqDTO;
import com.anderson.model.AlunoRespDTO;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(controllers = SpringAlunoController.class)
class SpringAlunoControllerTestBase {
    String urlBase="/alunos";

    String erroFindByIdAlunoNaoEncontrado = "Aluno não encontrado";
    String erroCreateAlunoNull = "O Aluno não deve ser nulo";
    String erroCreateAlunoExistente = "O Aluno já existente!";
    String erroCreateAlunoNomeNull = "O nome do Aluno não deve ser nulo";
    String erroCreateAlunoMatriculaNull = "A matrícula do Aluno não deve ser nulo";

    @MockBean
    public AlunoController alunoController;

    public AlunoReqDTO alunoReqDTO;
    public AlunoRespDTO alunoRespDTO;

    @Autowired
    public MockMvc mockMvc;


    @BeforeEach
    void init() {

        alunoReqDTO=new AlunoReqDTO();
        alunoReqDTO.setNome("Aluno 01");
        alunoReqDTO.setMatricula("qwa123456");
        alunoRespDTO=new AlunoRespDTO();
        alunoRespDTO.setId(1L);
        alunoRespDTO.setNome("Aluno 01");
        alunoRespDTO.setMatricula("qwa123456");
    }

}
package com.anderson.input;

import com.anderson.aluno.AlunoUsecaseServiceImpl;
import com.anderson.model.AlunoReqDTO;
import com.anderson.model.AlunoRespDTO;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

class AlunoInputBaseTest {
    String erroFindByIdAlunoNaoEncontrado = "Aluno não encontrado";
    String erroCreateAlunoNull = "O Aluno não deve ser nulo";
    String erroCreateAlunoExistente = "O Aluno já existente!";
    String erroCreateAlunoNomeNull = "O nome do Aluno não deve ser nulo";
    String erroCreateAlunoMatriculaNull = "A matrícula do Aluno não deve ser nulo";

    public AlunoInput alunoInput;
    public AlunoUsecaseServiceImpl alunoUsecaseService;

    public AlunoReqDTO alunoReqDTO;
    public AlunoRespDTO alunoRespDTO;

    @BeforeEach
    void init() {
        alunoInput = mock(AlunoInput.class);
        alunoUsecaseService=mock(AlunoUsecaseServiceImpl.class);
        alunoReqDTO=new AlunoReqDTO();
        alunoReqDTO.setNome("Aluno 01");
        alunoReqDTO.setMatricula("qwa123456");
        alunoRespDTO=new AlunoRespDTO();
        alunoRespDTO.setId(1L);
        alunoRespDTO.setNome("Aluno 01");
        alunoRespDTO.setMatricula("qwa123456");
    }

}
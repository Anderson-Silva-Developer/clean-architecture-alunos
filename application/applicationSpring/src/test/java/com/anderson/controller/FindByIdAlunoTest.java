package com.anderson.controller;

import com.anderson.aluno.exception.FindAlunoException;
import com.anderson.controller.util.UtilTest;
import com.anderson.model.AlunoRespDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindByIdAlunoTest extends SpringAlunoControllerTestBase{

    @Test
    @DisplayName("findByIdAluno_ok, deve retornar um alunoRespDTO e status 200")
    void findByIdAluno_ok() throws Exception {
        Long id=1L;
        Mockito.when(this.alunoController.findByIdAluno(id)).thenReturn(this.alunoRespDTO);
        MvcResult mvcResult = new UtilTest().generic_get200(mockMvc,urlBase+"/{id}",id);
        AlunoRespDTO alunoRespDTOResult = this.alunoController.findByIdAluno(id);
        assertTrue(alunoRespDTOResult==this.alunoRespDTO);
        assertEquals(mvcResult.getResponse().getStatus(), 200);
    }
    @Test
    @DisplayName("findByIdAluno_nao_encontrado_erro, deve retornar uma exception do tipo FindAlunoException")
    void findByIdAluno_nao_encontrado_erro() throws Exception {
        Long id=110L;
        Mockito.when(this.alunoController.findByIdAluno(id)).thenThrow(new FindAlunoException(erroFindByIdAlunoNaoEncontrado));
        MvcResult mvcResult =new UtilTest().generic_get200(mockMvc,urlBase+"/{id}",id);
        try {
            this.alunoController.findByIdAluno(id);

        }catch (FindAlunoException exception){
            System.out.println(exception.getMessage());
            assertEquals(exception.getMessage(),erroFindByIdAlunoNaoEncontrado);
        }

    }
}
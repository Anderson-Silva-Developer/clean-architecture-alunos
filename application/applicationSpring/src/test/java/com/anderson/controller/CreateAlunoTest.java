package com.anderson.controller;

import com.anderson.aluno.exception.AlunoAlreadyExistsException;
import com.anderson.aluno.exception.AlunoValidationException;
import com.anderson.controller.util.UtilTest;
import com.anderson.model.AlunoRespDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

class CreateAlunoTest extends SpringAlunoControllerTestBase{

    @Test
    @DisplayName("createAluno_ok, deve retornar um alunoRespDTO e status 201")
    void createAluno_ok() throws Exception {
        Mockito.when(this.alunoController.create(this.alunoReqDTO)).thenReturn(this.alunoRespDTO);
        MvcResult mvcResult = new UtilTest().create_post201(mockMvc,urlBase,this.alunoReqDTO);
        AlunoRespDTO alunoRespDTOResult = this.alunoController.create(this.alunoReqDTO);
        assertTrue(alunoRespDTOResult==this.alunoRespDTO);
        assertEquals(mvcResult.getResponse().getStatus(), 201);
    }
    @Test
    @DisplayName("createAluno_Aluno_existente_erro, deve retornar uma exception do tipo AlunoAlreadyExistsException")
    void createAluno_Aluno_existente_erro() throws Exception {
        Mockito.when(this.alunoController.create(any()))
                .thenThrow(new AlunoAlreadyExistsException(erroCreateAlunoExistente));
        MvcResult mvcResult = new UtilTest().create_post400(mockMvc,urlBase,this.alunoReqDTO);
        try{
           this.alunoController.create(this.alunoReqDTO);
        }catch(AlunoAlreadyExistsException exception){
            assertEquals(exception.getMessage(),erroCreateAlunoExistente);
            assertEquals(mvcResult.getResponse().getStatus(), 400);
        }
    }
    @Test
    @DisplayName("createAluno_Aluno_nulo_erro, deve retornar uma exception do tipo AlunoValidationException")
    void createAluno_Aluno_nulo_erro() throws Exception {
        Mockito.when(this.alunoController.create(null))
                .thenThrow(new AlunoValidationException(erroCreateAlunoNull));
        MvcResult mvcResult = new UtilTest().create_post400(mockMvc,urlBase,null);
        try{
            this.alunoController.create(null);

        }catch(AlunoValidationException exception){
            assertEquals(exception.getMessage(),erroCreateAlunoNull);
            assertEquals(mvcResult.getResponse().getStatus(),400);

        }
    }
    @Test
    @DisplayName("createAluno_nome_nulo_erro, deve retornar uma exception do tipo AlunoValidationException")
    void createAluno_nome_nulo_erro() throws Exception {
        this.alunoReqDTO.setNome("");
        Mockito.when(this.alunoController.create(any()))
                .thenThrow(new AlunoValidationException(erroCreateAlunoNomeNull));
        MvcResult mvcResult = new UtilTest().create_post400(mockMvc,urlBase,this.alunoReqDTO);
        try{
            this.alunoController.create(this.alunoReqDTO);

        }catch(AlunoValidationException exception){
            assertEquals(exception.getMessage(),erroCreateAlunoNomeNull);
            assertEquals(mvcResult.getResponse().getStatus(),400);
        }

    }
    @Test
    @DisplayName("createAluno_matricula_nula_erro, deve retornar uma exception do tipo AlunoValidationException")
    void createAluno_matricula_nula_erro() throws Exception {
        this.alunoReqDTO.setMatricula("");
        Mockito.when(this.alunoController.create(any()))
                .thenThrow(new AlunoValidationException(erroCreateAlunoNomeNull));
        MvcResult mvcResult = new UtilTest().create_post400(mockMvc,urlBase,this.alunoReqDTO);
        try{
            this.alunoController.create(this.alunoReqDTO);

        }catch(AlunoValidationException exception){
            assertEquals(exception.getMessage(),erroCreateAlunoNomeNull);
            assertEquals(mvcResult.getResponse().getStatus(),400);
        }

    }
}
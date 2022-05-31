package com.anderson.controller;

import com.anderson.aluno.exception.AlunoValidationException;
import com.anderson.model.AlunoRespDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CreateTest extends AlunoControllerTestBase{

    @Test
    @DisplayName("create_ok, deve retornar AlunoRespDTO")
    void create_ok() {
        when(this.alunoController.create(this.alunoReqDTO)).thenReturn(this.alunoRespDTO);
        AlunoRespDTO alunoRespDTOResult = this.alunoController.create(this.alunoReqDTO);
        assertEquals(alunoRespDTOResult.getId(),1);
    }
    @Test
    @DisplayName("create_nulo_erro, deve retornar uma exception do tipo  AlunoValidationException")
    void create_nulo_erro() {

        when(this.alunoController.create(null)).thenThrow(new AlunoValidationException(erroCreateAlunoNull));
        try {
            this.alunoController.create(this.alunoReqDTO);
        }catch (AlunoValidationException exception){
            assertEquals(exception.getMessage(),erroCreateAlunoNull);
        }
    }
    @Test
    @DisplayName("create_nome_nulo_erro, deve retornar uma exception do tipo  AlunoValidationException")
    void create_nome_nulo_erro() {
        this.alunoReqDTO.setNome("");
        when(this.alunoController.create(this.alunoReqDTO)).thenThrow(new AlunoValidationException(erroCreateAlunoNomeNull));
        try {
            this.alunoController.create(this.alunoReqDTO);
        }catch (AlunoValidationException exception){
            assertEquals(exception.getMessage(),erroCreateAlunoNomeNull);
        }
    }
    @Test
    @DisplayName("create_matricula_nula_erro, deve retornar uma exception do tipo  AlunoValidationException")
    void create_matricula_nula_erro() {
        this.alunoReqDTO.setMatricula("");
        when(this.alunoController.create(this.alunoReqDTO)).thenThrow(new AlunoValidationException(erroCreateAlunoMatriculaNull));
        try {
            this.alunoController.create(this.alunoReqDTO);
        }catch (AlunoValidationException exception){
            assertEquals(exception.getMessage(),erroCreateAlunoMatriculaNull);
        }

    }
}
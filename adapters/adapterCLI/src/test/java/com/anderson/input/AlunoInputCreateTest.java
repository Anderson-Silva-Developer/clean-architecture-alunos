package com.anderson.input;

import com.anderson.aluno.exception.AlunoAlreadyExistsException;
import com.anderson.aluno.exception.AlunoValidationException;
import com.anderson.model.AlunoRespDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AlunoInputCreateTest extends AlunoInputBaseTest{

    @Test
    @DisplayName("create_ok, deve retornar AlunoRespDTO")
    void create_ok() {
        when(this.alunoInput.create(this.alunoReqDTO)).thenReturn(this.alunoRespDTO);
        AlunoRespDTO alunoRespDTOResult = this.alunoInput.create(this.alunoReqDTO);
        assertEquals(alunoRespDTOResult.getId(),1);
    }
    @Test
    @DisplayName("create_existente_erro, deve retornar uma exception do tipo AlunoAlreadyExistsException")
    void create_existente_erro() {
        when(this.alunoInput.create(this.alunoReqDTO)).thenThrow(new AlunoAlreadyExistsException(erroCreateAlunoExistente));
        try {
            this.alunoInput.create(this.alunoReqDTO);

        }catch (AlunoAlreadyExistsException exception){
            assertEquals(exception.getClass(), AlunoAlreadyExistsException.class);
            assertEquals(exception.getMessage(), erroCreateAlunoExistente);

        }

    }

    @Test
    @DisplayName("create_nulo_erro, deve retornar uma exception do tipo  AlunoValidationException")
    void create_nulo_erro() {

        when(this.alunoInput.create(null)).thenThrow(new AlunoValidationException(erroCreateAlunoNull));
        try {
            this.alunoInput.create(this.alunoReqDTO);
        }catch (AlunoValidationException exception){
            assertEquals(exception.getMessage(),erroCreateAlunoNull);
        }
    }
    @Test
    @DisplayName("create_nome_nulo_erro, deve retornar uma exception do tipo  AlunoValidationException")
    void create_nome_nulo_erro() {
        this.alunoReqDTO.setNome("");
        when(this.alunoInput.create(this.alunoReqDTO)).thenThrow(new AlunoValidationException(erroCreateAlunoNomeNull));
        try {
            this.alunoInput.create(this.alunoReqDTO);
        }catch (AlunoValidationException exception){
            assertEquals(exception.getMessage(),erroCreateAlunoNomeNull);
        }
    }
    @Test
    @DisplayName("create_matricula_nula_erro, deve retornar uma exception do tipo  AlunoValidationException")
    void create_matricula_nula_erro() {
        this.alunoReqDTO.setMatricula("");
        when(this.alunoInput.create(this.alunoReqDTO)).thenThrow(new AlunoValidationException(erroCreateAlunoMatriculaNull));
        try {
            this.alunoInput.create(this.alunoReqDTO);
        }catch (AlunoValidationException exception){
            assertEquals(exception.getMessage(),erroCreateAlunoMatriculaNull);
        }

    }
}
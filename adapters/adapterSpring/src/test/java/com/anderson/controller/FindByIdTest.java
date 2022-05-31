package com.anderson.controller;

import com.anderson.aluno.exception.FindAlunoException;
import com.anderson.model.AlunoRespDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FindByIdTest extends AlunoControllerTestBase{

    @Test
    @DisplayName("findById_ok, deve retornar AlunoRespDTO")
    void findById_ok() {
        Long id=1L;
        when(this.alunoController.findByIdAluno(id)).thenReturn(this.alunoRespDTO);
        AlunoRespDTO alunoRespDTOResult = this.alunoController.findByIdAluno(id);
        assertEquals(alunoRespDTOResult.getId(),1);
    }
    @Test
    @DisplayName("findById_nao_encontrado_erro, deve retornar uma exception do tipo FindAlunoException")
    void findById_nao_encontrado_erro() {
        Long id=100L;
        when(this.alunoController.findByIdAluno(id)).thenThrow(new FindAlunoException(erroFindByIdAlunoNaoEncontrado));
        try {
            this.alunoController.findByIdAluno(id);
        }catch (FindAlunoException exception){
            assertEquals(exception.getMessage(),erroFindByIdAlunoNaoEncontrado);
        }




    }

}
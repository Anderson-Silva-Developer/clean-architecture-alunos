package com.anderson.controller;

import com.anderson.aluno.exception.FindAlunoException;
import com.anderson.model.AlunoRespDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FindByMatriculaTest extends AlunoControllerTestBase{

    @Test
    @DisplayName("findByIMatricula_ok, deve retornar AlunoRespDTO")
    void findByIMatricula_ok() {
        String matricula =this.alunoReqDTO.getMatricula();
        when(this.alunoController.findByMatriculaAluno(matricula)).thenReturn(this.alunoRespDTO);
        AlunoRespDTO alunoRespDTOResult = this.alunoController.findByMatriculaAluno(matricula);
        assertEquals(alunoRespDTOResult.getId(),1);
    }
    @Test
    @DisplayName("findByMatricula_nao_encontrado_erro, deve retornar uma exception do tipo FindAlunoException")
    void findByMatricula_nao_encontrado_erro() {
        String matricula="matriculaquenaoexiste343434343";
        when(this.alunoController.findByMatriculaAluno(matricula)).thenThrow(new FindAlunoException(erroFindByIdAlunoNaoEncontrado));
        try {
            this.alunoController.findByMatriculaAluno(matricula);
        }catch (FindAlunoException exception){
            assertEquals(exception.getMessage(),erroFindByIdAlunoNaoEncontrado);
        }




    }

}
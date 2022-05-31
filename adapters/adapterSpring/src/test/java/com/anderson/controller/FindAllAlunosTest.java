package com.anderson.controller;

import com.anderson.model.AlunoRespDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class FindAllAlunosTest extends AlunoControllerTestBase{

    @Test
    @DisplayName("findAllAlunos_ok, deve retornar todos os alunos cadastrados")
    void findAllAlunos_ok() {
        when(this.alunoController.findAllAlunos()).thenReturn(Arrays.asList(this.alunoRespDTO));
        List<AlunoRespDTO> alunoList = this.alunoController.findAllAlunos();
        assertEquals(alunoList.get(0).getId(),1);
    }
    @Test
    @DisplayName("findAllAlunos_lista_vazia, deve retornar uma lista vazia não há alunos cadastrados")
    void findAllAlunos_lista_vazia() {

        when(this.alunoController.findAllAlunos()).thenReturn(Arrays.asList());
        List<AlunoRespDTO> alunoList = this.alunoController.findAllAlunos();
        assertTrue(alunoList.isEmpty());

    }

}
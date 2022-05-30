package com.anderson.aluno;

import com.anderson.entities.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindAllAlunos {
    private List<Aluno> listAlunos;

    private AlunoUsecaseServiceImpl alunoUsecaseService;

    @BeforeEach
    void init() {
        alunoUsecaseService=mock(AlunoUsecaseServiceImpl.class);
        listAlunos = new ArrayList<>(Arrays.asList(
                new Aluno.AlunoBuilder()
                        .id(1L)
                        .nome("Aluno 01")
                        .matricula("234kkds")
                        .build(),
                new Aluno.AlunoBuilder()
                        .id(2L)
                        .nome("Aluno 02")
                        .matricula("234kkds45")
                        .build()
        ));

    }


    @Test
    @DisplayName("findAllAlunos_alunos_cadastrados, deve retornar todos os alunos da lista")
    void findAllAlunos_alunos_cadastrados() {
        when(this.alunoUsecaseService.findAllAlunos()).thenReturn(listAlunos);
        List<Aluno> listAlunosResult = this.alunoUsecaseService.findAllAlunos();
        assertEquals(listAlunosResult,listAlunos);

    }
    @Test
    @DisplayName("findAllAlunos_nenhum_alunos_cadastrados, deve retornar lista vazia")
    void findAllAlunos_nenhum_alunos_cadastrados() {
        when(this.alunoUsecaseService.findAllAlunos()).thenReturn(List.of());
        List<Aluno> listAlunosResult = this.alunoUsecaseService.findAllAlunos();
        assertTrue(listAlunosResult.isEmpty());

    }
}
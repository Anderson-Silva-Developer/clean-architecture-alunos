package com.anderson.aluno;

import com.anderson.aluno.exception.FindAlunoException;
import com.anderson.entities.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class findByMatricula {

    String erroFindByIdAlunoNaoEncontrado = "Aluno não encontrado";

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
    @DisplayName("findByMatricula_ok, deve retornar o aluno do Id 1 ")
    void findByMatricula_ok() {
        String matricula="234kkds";
        when(this.alunoUsecaseService.findByMatricula(matricula)).thenReturn(Optional.ofNullable(listAlunos.get(0)));
        Optional<Aluno> newAluno = this.alunoUsecaseService.findByMatricula(matricula);
        assertEquals(Objects.nonNull(newAluno.get()),true);
        assertEquals(newAluno.get().getMatricula().equals(matricula),true);
    }
    @Test
    @DisplayName("findByMatricula_nao_encontrado, deve retornar uma exception do tipo FindAlunoException")
    void findByMatricula_nao_encontrado() {
        String matricula="234kkds";
        when(this.alunoUsecaseService.findByMatricula(matricula)).thenThrow(new FindAlunoException(erroFindByIdAlunoNaoEncontrado));
        try {
            this.alunoUsecaseService.findByMatricula(matricula);
        }catch (FindAlunoException exception){
            assertEquals(exception.getClass(),FindAlunoException.class);
            assertEquals(exception.getMessage(),erroFindByIdAlunoNaoEncontrado);
        }

    }
}
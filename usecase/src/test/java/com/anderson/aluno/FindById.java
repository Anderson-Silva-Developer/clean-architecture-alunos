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

class FindById {

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
    @DisplayName("findById_ok, deve retornar o aluno do Id 1 ")
    void findById_ok() {
        Long id=1L;
        when(this.alunoUsecaseService.findById(id)).thenReturn(Optional.ofNullable(listAlunos.get(0)));
        Optional<Aluno> newAluno = this.alunoUsecaseService.findById(id);
        assertEquals(Objects.nonNull(newAluno.get()),true);
        assertEquals(newAluno.get().getId(),id);
    }
    @Test
    @DisplayName("findById_nao_econtrado, deve retornar uma exception do tipo FindAlunoException")
    void findById_nao_encontrado() {
        Long id=10L;
        when(this.alunoUsecaseService.findById(id)).thenThrow(new FindAlunoException(erroFindByIdAlunoNaoEncontrado));
       try {
           Optional<Aluno> newAluno = this.alunoUsecaseService.findById(id);
       }catch (FindAlunoException exception){
           assertEquals(exception.getClass(),FindAlunoException.class);
           assertEquals(exception.getMessage(),erroFindByIdAlunoNaoEncontrado);
       }

    }

    }

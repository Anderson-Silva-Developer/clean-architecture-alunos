package com.anderson.aluno;

import com.anderson.aluno.contract.useCaseRepository.AlunoRepository;
import com.anderson.aluno.exception.AlunoAlreadyExistsException;
import com.anderson.aluno.exception.AlunoValidationException;
import com.anderson.entities.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class Create {

    String erroCreateAlunoNull = "O Aluno não deve ser nulo";
    String erroCreateAlunoExistente = "O Aluno já existente!";
    String erroCreateAlunoNomeNull = "O nome do Aluno não deve ser nulo";
    String erroCreateAlunoMatriculaNull = "A matrícula do Aluno não deve ser nulo";
    private List<Aluno> list;

    private AlunoRepository alunoRepository;

    private AlunoUsecaseServiceImpl alunoUsecaseService;

    @BeforeEach
    void init() {
        alunoRepository = mock(AlunoRepository.class);
        alunoUsecaseService=mock(AlunoUsecaseServiceImpl.class);

        list = new ArrayList<>(Arrays.asList(
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
    @DisplayName("create_ok, deve retornar um novo aluno")
    void create_ok() {
        when(this.alunoUsecaseService.create(list.get(0))).thenReturn(list.get(0));
        Aluno newAluno = this.alunoUsecaseService.create(list.get(0));
        assertEquals(newAluno, list.get(0));
    }
    @Test
    @DisplayName("create_existente_erro, deve retornar uma exception do tipo AlunoAlreadyExistsException")
    void create_existente_erro() {
        when(this.alunoRepository.findByMatricula(list.get(0).getMatricula())).thenReturn(Optional.of(list.get(0)));
        when(this.alunoUsecaseService.create(list.get(0))).thenThrow(new AlunoAlreadyExistsException(erroCreateAlunoExistente));
       try {
           Aluno newAluno = this.alunoUsecaseService.create(list.get(0));
           assertEquals(newAluno, list.get(0));

       }catch (AlunoAlreadyExistsException exception){
           assertEquals(exception.getClass(), AlunoAlreadyExistsException.class);
           assertEquals(exception.getMessage(), erroCreateAlunoExistente);

       }

    }

    @Test
    @DisplayName("create_aluno_nulo_erro, deve retornar uma exception do tipo AlunoValidationException")
    void create_aluno_nulo_erro() {
        when(this.alunoUsecaseService.create(null)).thenThrow(new AlunoValidationException(erroCreateAlunoNull));
        try {
            Aluno newAluno = this.alunoUsecaseService.create(null);
            assertEquals(newAluno, list.get(0));

        } catch (AlunoValidationException exception) {
            assertEquals(exception.getClass(), AlunoValidationException.class);
            assertEquals(exception.getMessage(), erroCreateAlunoNull);
        }
    }
    @Test
    @DisplayName("create_nome_nulo_erro, deve retornar uma exception do tipo AlunoValidationException")
    void create_nome_nulo_erro() {
        Aluno  aluno=list.get(0);
        aluno.setNome("");
        when(this.alunoUsecaseService.create(aluno)).thenThrow(new AlunoValidationException(erroCreateAlunoNomeNull));
        try {
            Aluno newAluno = this.alunoUsecaseService.create(aluno);
            assertEquals(newAluno, list.get(0));

        } catch (AlunoValidationException exception) {
            assertEquals(exception.getClass(), AlunoValidationException.class);
            assertEquals(exception.getMessage(), erroCreateAlunoNomeNull);
        }
    }
    @Test
    @DisplayName("create_matricula_nulo_erro, deve retornar uma exception do tipo AlunoValidationException")
    void create_matricula_nulo_erro() {
        Aluno  aluno=list.get(0);
        aluno.setMatricula("");
        when(this.alunoUsecaseService.create(aluno)).thenThrow(new AlunoValidationException(erroCreateAlunoMatriculaNull));
        try {
            Aluno newAluno = this.alunoUsecaseService.create(aluno);
            assertEquals(newAluno, list.get(0));

        } catch (AlunoValidationException exception) {
            assertEquals(exception.getClass(), AlunoValidationException.class);
            assertEquals(exception.getMessage(), erroCreateAlunoMatriculaNull);
        }
    }
}
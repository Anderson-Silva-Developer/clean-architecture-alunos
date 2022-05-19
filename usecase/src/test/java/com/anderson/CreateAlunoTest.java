package com.anderson;

import com.anderson.entities.Aluno;
import com.anderson.exception.AlunoAlreadyExistsException;
import com.anderson.exception.AlunoValidationException;
import com.anderson.mock.AlunoRepositoryMock;
import com.anderson.repository.AlunoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CreateAlunoTest {
    String getErroAluno="O Aluno não deve ser nulo";
    String getErroAlunoExiste="O Aluno já existente!";
    String erroId="O Id do Aluno não deve ser nulo";
    String erroNome="O nome do Aluno não deve ser nulo";
    String erroMatricula="A matrícula do Aluno não deve ser nulo";

    private final AlunoRepository alunoRepository = new AlunoRepositoryMock();
    private final CreateAluno createAluno=new CreateAluno(alunoRepository);
    Aluno aluno=new Aluno.AlunoBuilder()
            .id(1L)
            .nome("Aluno 01")
            .matricula("2022xx01")
            .build();

    @Test
    @DisplayName("Teste criar aluno, espera-se ok")
    void create_0k() {
        Aluno alunoCreate = createAluno.create(aluno);
        assertEquals(alunoCreate,aluno);
    }
    @Test
    @DisplayName("Teste  aluno nulo, espera-se erro")
    void create_erro_aluno_nulo() {
        //erro aluno nulo
        this.aluno=null;
        AlunoValidationException exception = assertThrows(AlunoValidationException.class, () -> createAluno.create(aluno));
        assertEquals(exception.getMessage().equals(getErroAluno),true);

    }
    @Test
    @DisplayName("Teste Id nulo, espera-se erro")
    void create_erro_Id_nulo() {
        //erro Id nulo
        aluno.setId(null);
        AlunoValidationException exception = assertThrows(AlunoValidationException.class, () -> createAluno.create(aluno));
        assertEquals(exception.getMessage().equals(erroId),true);

    }
    @Test
    @DisplayName("Teste nome nulo, espera-se erro")
    void create_erro_nome_nulo() {
       ///nome nulo
        aluno.setNome(null);
        AlunoValidationException exception = assertThrows(AlunoValidationException.class, () -> createAluno.create(aluno));
        assertEquals(exception.getMessage().equals(erroNome),true);

    }
    @Test
    @DisplayName("Teste matricula nula, espera-se erro")
    void create_erro_matricula_nula() {
        ///matricula nulo
        aluno.setMatricula(null);
        AlunoValidationException exception = assertThrows(AlunoValidationException.class, () -> createAluno.create(aluno));
        assertEquals(exception.getMessage().equals(erroMatricula),true);

    }
    @Test
    @DisplayName("Teste alunos Id duplicado, espera-se erro")
    void create_erro_Id_duplicado() {
        aluno.setMatricula("xxxx");
        createAluno.create(aluno);
        AlunoAlreadyExistsException exception = assertThrows(AlunoAlreadyExistsException.class, () -> createAluno.create(aluno));
        assertEquals(exception.getMessage().equals(getErroAlunoExiste),true);

    }
    @Test
    @DisplayName("Teste alunos matricula duplicada, espera-se erro")
    void create_erro_matricula_duplicada() {
        aluno.setId(2L);
        createAluno.create(aluno);
        AlunoAlreadyExistsException exception = assertThrows(AlunoAlreadyExistsException.class, () -> createAluno.create(aluno));
        assertEquals(exception.getMessage().equals(getErroAlunoExiste),true);

    }
}
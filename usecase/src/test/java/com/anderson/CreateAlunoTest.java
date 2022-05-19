package com.anderson;

import com.anderson.entities.Aluno;
import com.anderson.exception.AlunoAlreadyExistsException;
import com.anderson.mock.AlunoRepositoryMock;
import com.anderson.repository.AlunoRepository;
import com.anderson.validator.AlunoValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateAlunoTest {
    private final AlunoRepository alunoRepository = new AlunoRepositoryMock();

    @Test
    void create_0k() {
        CreateAluno createAluno=new CreateAluno(alunoRepository);
        Aluno aluno=new Aluno.AlunoBuilder()
                .id(1L)
                .nome("Anderson Silva")
                .matricula("2022xx01")
                .build();
        Aluno alunoCreate = createAluno.create(aluno);
        assertEquals(alunoCreate,aluno);
    }
}
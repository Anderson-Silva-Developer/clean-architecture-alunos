package com.anderson;

import com.anderson.entities.Aluno;
import com.anderson.aluno.exception.FindAlunoException;
import com.anderson.mock.AlunoRepositoryMock;
import com.anderson.aluno.contract.useCaseRepository.AlunoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class FindAlunoTest {
    String ErroAlunoNaoEncontrado="Aluno não encontrado";
    private final AlunoRepository alunoRepository = new AlunoRepositoryMock();
    private final FindAluno findAluno=new FindAluno(alunoRepository);
//
    private List<Aluno>  alunoList= Arrays.asList(
            new Aluno.AlunoBuilder().id(1L).nome("Aluno 01").matricula("xxxxasas").build(),
            new Aluno.AlunoBuilder().id(2L).nome("Aluno 02").matricula("ewewasas").build(),
            new Aluno.AlunoBuilder().id(3L).nome("Aluno 03").matricula("ytytasas").build()
    );

    @Test
    @DisplayName("Teste findById, espera-se ok")
    void findById_ok() {
        alunoRepository.create(alunoList.get(0));
        Aluno aluno= findAluno.findById(1L).get();
        assertTrue(Objects.nonNull(aluno));
        assertEquals(aluno.getId(),alunoList.get(0).getId());
    }
    @Test
    @DisplayName("Teste findById não encontrado, espera-se erro")
    void findById_nao_encontrado() {
        alunoRepository.create(alunoList.get(0));
        FindAlunoException exception = assertThrows(FindAlunoException.class, () -> findAluno.findById(10L));
        assertEquals(exception.getMessage().equals(ErroAlunoNaoEncontrado),true);
    }
    @Test
    @DisplayName("Teste findByMatricula, espera-se ok")
    void findByMatricula_ok() {
        alunoRepository.create(alunoList.get(1));
        Aluno aluno=findAluno.findByMatricula(alunoList.get(1).getMatricula()).get();
        assertTrue(Objects.nonNull(aluno));
        assertEquals(aluno.getId(),alunoList.get(1).getId());
    }

    @Test
    @DisplayName("Teste findByMatricula não encontrado, espera-se erro")
    void findByMatricula_nao_encontrada() {
        alunoRepository.create(alunoList.get(1));
        FindAlunoException exception = assertThrows(FindAlunoException.class, () -> findAluno.findByMatricula(alunoList.get(2).getMatricula()));
        assertEquals(exception.getMessage().equals(ErroAlunoNaoEncontrado),true);
    }

    @Test
    @DisplayName("Teste findAllAlunos, espera-se todos")
    void findAllAlunos_todos() {
        alunoRepository.create(alunoList.get(0));
        alunoRepository.create(alunoList.get(1));
        alunoRepository.create(alunoList.get(2));
        findAluno.findAllAlunos().forEach(aluno -> System.out.println(aluno.toString()));
        assertTrue(!findAluno.findAllAlunos().isEmpty());

    }
    @Test
    @DisplayName("Teste findAllAlunos, espera-se lista vazia")
    void findAllAlunos_vazia() {
        assertTrue(findAluno.findAllAlunos().isEmpty());
    }
}
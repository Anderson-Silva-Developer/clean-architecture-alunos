package com.anderson.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void create_aluno_ok() {
        Aluno aluno=new Aluno.AlunoBuilder()
                .id(1L)
                .nome("Anderson Silva")
                .matricula("2022xx01")
                .build();
        System.out.println(aluno.toString());
    }
}
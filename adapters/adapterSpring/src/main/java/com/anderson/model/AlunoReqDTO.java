package com.anderson.model;

import com.anderson.entities.Aluno;

public class AlunoReqDTO {
    private String nome;
    private String matricula;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Aluno toAluno() {
        return new Aluno.AlunoBuilder()
                .nome(this.nome)
                .matricula(this.matricula)
                .build();
    }

}

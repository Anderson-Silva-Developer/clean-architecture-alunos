package com.anderson.entity;

import com.anderson.entities.Aluno;

import javax.persistence.*;

@Entity
@Table(name = "ALUNO")
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String matricula;

    public AlunoEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public AlunoEntity(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    public  Aluno toAluno(){
        return new Aluno.AlunoBuilder()
                .id(this.id)
                .nome(this.nome)
                .matricula(this.matricula)
                .build();
    }
    public  AlunoEntity fromAluno(Aluno aluno){
        return new AlunoEntity(aluno.getNome(),aluno.getMatricula());
    }
}

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

    private AlunoEntity(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    public static class AlunoEntityBuilder{
        private String nome;
        private String matricula;

        public AlunoEntityBuilder() { }

        public AlunoEntityBuilder nome(String nome) {
            this.nome=nome;
            return this;
        }
        public AlunoEntityBuilder matricula(String matricula) {
            this.matricula=matricula;
            return this;
        }
        public AlunoEntity build(){
            return new AlunoEntity(nome,matricula);
        }

    }

    public  Aluno toAluno(){
        return new Aluno.AlunoBuilder()
                .id(this.id)
                .nome(this.nome)
                .matricula(this.matricula)
                .build();
    }
    public  AlunoEntity fromAluno(Aluno aluno){
        return new AlunoEntityBuilder()
                .nome(aluno.getNome())
                .matricula(aluno.getMatricula())
                .build();
    }
}

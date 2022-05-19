package com.anderson.entities;

public class Aluno {
    private Long id;
    private String nome;
    private String matricula;

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

    private Aluno(Long id, String nome, String matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }
    public static class AlunoBuilder{
        private Long id;
        private String nome;
        private String matricula;

        public AlunoBuilder() {
        }

        public AlunoBuilder id(Long id) {
            this.id=id;
            return this;
        }

        public AlunoBuilder nome(String nome) {
            this.nome=nome;
            return this;
        }
        public AlunoBuilder matricula(String matricula) {
            this.matricula=matricula;
            return this;
        }
        public Aluno build(){
            return new Aluno(this.id,this.nome,this.matricula);
        }

    }

    @Override
    public String toString() {
        return "Aluno:{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}

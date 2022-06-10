package com.anderson.model;

import com.anderson.entities.Aluno;

public class AlunoRespDTO {
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public static AlunoRespDTO toAlunoDTO(final Aluno aluno) {
        var alunoDTO =new AlunoRespDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setMatricula(aluno.getMatricula());
        return alunoDTO;
    }

    @Override
    public String toString() {
        return "\nAluno:{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula +'\'' +
                '}';
    }
}

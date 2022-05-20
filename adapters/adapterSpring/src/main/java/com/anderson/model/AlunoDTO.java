package com.anderson.model;

import com.anderson.entities.Aluno;

public class AlunoDTO {
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

    public Aluno toAluno() {
        return new Aluno.AlunoBuilder()
                .nome(this.nome)
                .matricula(this.matricula)
                .build();
    }
    public static AlunoDTO toAlunoDTO(final Aluno aluno) {
        var alunoDTO =new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setMatricula(aluno.getMatricula());
        return alunoDTO;
    }


}

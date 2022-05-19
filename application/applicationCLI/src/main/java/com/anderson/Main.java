package com.anderson;

import com.anderson.entities.Aluno;

public class Main {
    public static void main(String[] args) {
        var config = new ManualConfig();
        var createAluno = config.createAluno();
        var findAluno = config.findAluno();
        Aluno aluno = new Aluno.AlunoBuilder()
                .id(1L)
                .nome("Aluno 01")
                .matricula("2022xx01")
                .build();
        Aluno aluno2 = new Aluno.AlunoBuilder()
                .id(2L)
                .nome("Aluno 02")
                .matricula("2022xx02")
                .build();
        try {
            CreatealunoMain(aluno, createAluno);
            FinfByIdAlunoMain(aluno.getId(), findAluno);
            CreatealunoMain(aluno2, createAluno);
            FinfByIdAlunoMain(aluno2.getId(), findAluno);
            FindAllAlunosMain(findAluno);
            FinfByIdAlunoMain(20L, findAluno);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        }

    }

    private static void FindAllAlunosMain(FindAluno findAluno) {
        //listar todos os alunos
        System.out.println("listar todos os Alunos");
        var alunos = findAluno.findAllAlunos();
        System.out.println(alunos);
        System.out.println("###################");
    }

    private static void FinfByIdAlunoMain(Long id, FindAluno findAluno) {
//        buscar aluno pelo id
        var actualFindAluno = findAluno.findById(id);
        System.out.println("buscar aluno pelo id: " + actualFindAluno.get().getNome());
    }

    public static Aluno CreatealunoMain(Aluno aluno, CreateAluno createAluno) {
        //criar Aluno
        System.out.println("Criar Aluno : " + aluno.toString());
        var actualCreateAluno = createAluno.create(aluno);
        System.out.println("******************");
        return actualCreateAluno;
    }

}

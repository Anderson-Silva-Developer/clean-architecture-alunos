package com.anderson;

import com.anderson.input.AlunoInput;
import com.anderson.model.AlunoReqDTO;
import com.anderson.model.AlunoRespDTO;
import com.anderson.repository.AlunoRepositoryCLI;

public class Main {
    public static void main(String[] args) {
        var config = new ManualConfig(new AlunoRepositoryCLI());
        var alunoInput=new AlunoInput(config.alunoUsecaseServiceImpl());

        AlunoReqDTO alunoReqDTO = new AlunoReqDTO();
        alunoReqDTO.setNome("Aluno 09 main");
        alunoReqDTO.setMatricula("2022xx04fgj95849mbm");
        AlunoReqDTO alunoReqDTO2 = new AlunoReqDTO();
        alunoReqDTO2.setNome("Aluno 10 main");
        alunoReqDTO2.setMatricula("2022xx05gfglg8695895vbf");

        try {
            AlunoRespDTO newaluno = CreatealunoMain(alunoReqDTO, alunoInput);
            FinfByIdAlunoMain(newaluno.getId(),alunoInput);
            AlunoRespDTO newaluno2 = CreatealunoMain(alunoReqDTO2,alunoInput);
            FinfByIdAlunoMain(newaluno2.getId(),alunoInput);
            FindAllAlunosMain(alunoInput);
            FinfByIdAlunoMain(200L, alunoInput);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        }

    }

    private static void FindAllAlunosMain(AlunoInput alunoInput) {
        //listar todos os alunos
        System.out.println("listar todos os Alunos");
        var alunos =alunoInput.findAllAlunos();
        alunos.stream()
                .forEach(alunoRespDTO -> System.out.println(alunoRespDTO.toString()));
    }
//
    private static void FinfByIdAlunoMain(Long id,AlunoInput alunoInput) {
//        buscar aluno pelo id
        var actualFindAluno = alunoInput.findByIdAluno(id);
        System.out.println("buscar aluno pelo id: " + actualFindAluno.getId());
    }

    public static AlunoRespDTO CreatealunoMain(AlunoReqDTO alunoReqDTO, AlunoInput alunoInput) {
        //criar Aluno
        var actualCreateAluno = alunoInput.create(alunoReqDTO);
        return actualCreateAluno;
    }

}
//}

package com.anderson.aluno.validator;

import com.anderson.aluno.exception.AlunoValidationException;
import com.anderson.entities.Aluno;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class AlunoValidator {
    public static boolean validateCreateAluno(Aluno aluno) {
        if (Objects.isNull(aluno)) throw  new AlunoValidationException("O Aluno não deve ser nulo");
        if (isBlank(aluno.getNome())) throw new AlunoValidationException("O nome do Aluno não deve ser nulo");
        if (isBlank(aluno.getMatricula()))throw  new AlunoValidationException("A matrícula do Aluno não deve ser nulo");
        return true;
    }
}

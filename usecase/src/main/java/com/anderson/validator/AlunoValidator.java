package com.anderson.validator;

import com.anderson.entities.Aluno;
import com.anderson.exception.AlunoValidationException;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.Objects;

public class AlunoValidator {
    public static void validateCreateAluno(Aluno aluno) {
        if (Objects.isNull(aluno)) throw new AlunoValidationException("O Aluno não deve ser nulo");
        if (isBlank(aluno.getNome())) throw new AlunoValidationException("O nome do Aluno não deve ser nulo");
        if (isBlank(aluno.getMatricula())) throw new AlunoValidationException("A matrícula do Aluno não deve ser nulo");

    }
}

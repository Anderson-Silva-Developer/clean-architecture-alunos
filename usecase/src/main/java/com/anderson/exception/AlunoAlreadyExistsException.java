package com.anderson.exception;

public class AlunoAlreadyExistsException extends RuntimeException{
    public AlunoAlreadyExistsException(String msm) {
        super(msm);
    }
}

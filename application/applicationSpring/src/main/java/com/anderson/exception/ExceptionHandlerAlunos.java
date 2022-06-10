package com.anderson.exception;

import com.anderson.aluno.exception.AlunoAlreadyExistsException;
import com.anderson.aluno.exception.AlunoValidationException;
import com.anderson.aluno.exception.FindAlunoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAlunos {
    @ExceptionHandler(FindAlunoException.class)
    public ResponseEntity<DetalhesErro> InternaalException(FindAlunoException ex) {
        String titulo;
        titulo = "Erro ao buscar Aluno";
        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo(titulo);
        erro.setStatus(404L);
        erro.setMenssagemDesenvolvedor(ex.getMessage());
        erro.setTimestap(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    @ExceptionHandler(AlunoAlreadyExistsException.class)
    public ResponseEntity<DetalhesErro> InternaalException(AlunoAlreadyExistsException ex) {
        String titulo;
        titulo = "Erro ao criar Aluno";
        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo(titulo);
        erro.setStatus(400L);
        erro.setMenssagemDesenvolvedor(ex.getMessage());
        erro.setTimestap(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
    @ExceptionHandler(AlunoValidationException.class)
    public ResponseEntity<DetalhesErro> InternaalException(AlunoValidationException ex) {
        String titulo;
        titulo = "Erro preencha todas informações do Aluno";
        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo(titulo);
        erro.setStatus(400L);
        erro.setMenssagemDesenvolvedor(ex.getMessage());
        erro.setTimestap(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}

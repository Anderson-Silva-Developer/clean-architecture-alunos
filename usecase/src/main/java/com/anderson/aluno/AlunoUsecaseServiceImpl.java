package com.anderson.aluno;

import com.anderson.aluno.contract.useCaseRepository.AlunoRepository;
import com.anderson.aluno.contract.useCaseService.AlunoUsecaseService;
import com.anderson.aluno.exception.AlunoAlreadyExistsException;
import com.anderson.aluno.exception.FindAlunoException;
import com.anderson.aluno.validator.AlunoValidator;
import com.anderson.entities.Aluno;

import java.util.List;
import java.util.Optional;

public class AlunoUsecaseServiceImpl implements AlunoUsecaseService {

    private final AlunoRepository alunoRepository;

    public AlunoUsecaseServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno create(Aluno aluno) {
        AlunoValidator.validateCreateAluno(aluno);
        if(this.alunoRepository.findByMatricula(aluno.getMatricula()).isPresent()){
            throw new AlunoAlreadyExistsException("O Aluno já existente!");
        }
        return this.alunoRepository.create(aluno);
    }

    @Override
    public Optional<Aluno> findById(Long id) {
        return Optional.ofNullable(this.alunoRepository.findById(id).orElseThrow(() -> new FindAlunoException("Aluno não encontrado")));
    }

    @Override
    public Optional<Aluno> findByMatricula(String matricula) {
        return Optional.ofNullable(this.alunoRepository.findByMatricula(matricula).orElseThrow(() -> new FindAlunoException("Aluno não encontrado")));
    }

    @Override
    public List<Aluno> findAllAlunos() {
        return this.alunoRepository.findAllAlunos();
    }
}

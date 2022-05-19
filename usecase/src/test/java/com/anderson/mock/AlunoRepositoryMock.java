package com.anderson.mock;

import com.anderson.entities.Aluno;
import com.anderson.repository.AlunoRepository;

import java.util.*;

public class AlunoRepositoryMock implements AlunoRepository {
    private final Map<Object, Aluno> inMemoryDb = new HashMap<>();
    @Override
    public Aluno create(Aluno aluno) {
        this.inMemoryDb.put(aluno.getId(),aluno);
        return aluno;
    }

    @Override
    public Optional<Aluno> findById(Long id) {
        return Optional.ofNullable(this.inMemoryDb.get(id));
    }

    @Override
    public Optional<Aluno> findByMatricula(String matricula) {
        return this.inMemoryDb.values().stream()
                .filter(aluno -> aluno.getMatricula().equals(matricula))
                .findAny();
    }

    @Override
    public List<Aluno> findAllAlunos() {
        return new ArrayList<Aluno>(this.inMemoryDb.values());
    }
}

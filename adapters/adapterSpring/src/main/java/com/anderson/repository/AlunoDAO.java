package com.anderson.repository;

import com.anderson.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoDAO extends JpaRepository <AlunoEntity,Long> {
    Optional<AlunoEntity> findByMatricula(String matricula);
}

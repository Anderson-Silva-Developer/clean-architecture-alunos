package com.anderson.aluno;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({Create.class,FindAllAlunos.class,FindById.class,FindByMatricula.class})
class AlunoUsecaseServiceImplTest {

}
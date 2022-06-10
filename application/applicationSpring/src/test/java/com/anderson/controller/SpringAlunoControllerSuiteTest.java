package com.anderson.controller;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CreateAlunoTest.class,FindByIdAlunoTest.class,FindByMatriculaAlunoTest.class,FindByAllAlunosTest.class})
public class SpringAlunoControllerSuiteTest {
}

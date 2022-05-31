package com.anderson.controller;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CreateTest.class,FindByIdTest.class,FindByMatriculaTest.class,FindAllAlunosTest.class})
class AlunoControllerSuiteTest {

}
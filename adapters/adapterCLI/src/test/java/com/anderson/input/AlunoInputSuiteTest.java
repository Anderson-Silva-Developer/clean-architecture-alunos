package com.anderson.input;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CreateTest.class,FindByIdTest.class,FindByMatriculaTest.class,FindAllAlunosTest.class})
public class AlunoInputSuiteTest {
}

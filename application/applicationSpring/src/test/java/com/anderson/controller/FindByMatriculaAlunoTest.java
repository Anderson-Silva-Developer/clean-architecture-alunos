package com.anderson.controller;

class FindByMatriculaAlunoTest extends SpringAlunoControllerTestBase{

//    @Test
//    @DisplayName("findByMatriculaAluno_ok, deve retornar um alunoRespDTO e status 200")
//    void findByMatriculaAluno_ok() throws Exception {
//        String matricula =this.alunoReqDTO.getMatricula();
//        Mockito.when(this.alunoController.findByMatriculaAluno(matricula)).thenReturn(this.alunoRespDTO);
//        MvcResult mvcResult = new UtilTest().generic_get200(mockMvc,urlBase+"/matricula/{matriculaAluno}",matricula);
//        AlunoRespDTO alunoRespDTOResult = this.alunoController.findByMatriculaAluno(matricula);
//        assertTrue(alunoRespDTOResult==this.alunoRespDTO);
//        assertEquals(mvcResult.getResponse().getStatus(), 200);
//    }
//    @Test
//    @DisplayName("findByMatriculaAluno_nao_encontrado_erro, deve retornar uma exception do tipo FindAlunoException")
//    void findByMatriculaAluno_nao_encontrado_erro() throws Exception {
//        String matricula =this.alunoReqDTO.getMatricula();
//        Mockito.when(this.alunoController.findByMatriculaAluno(matricula)).thenThrow(new FindAlunoException(erroFindByIdAlunoNaoEncontrado));
//        MvcResult mvcResult =new UtilTest().generic_get200(mockMvc,urlBase+"/matricula/{matriculaAluno}",matricula);
//        try {
//            this.alunoController.findByMatriculaAluno(matricula);
//
//        }catch (FindAlunoException exception){
//            assertEquals(exception.getMessage(),erroFindByIdAlunoNaoEncontrado);
//        }
//
//    }
}
package com.anderson.controller;

import com.anderson.controller.util.UtilTest;
import com.anderson.model.AlunoRespDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindByAllAlunosTest extends SpringAlunoControllerTestBase{

    @Test
    @DisplayName("findAllAlunos_ok, deve retornar uma lista de alunoRespDTO e status 200")
    void findAllAlunos_ok() throws Exception {

        Mockito.when(this.alunoController.findAllAlunos()).thenReturn(Arrays.asList(this.alunoRespDTO));
        MvcResult mvcResult = new UtilTest().findAllAlunos_get200(mockMvc,urlBase);
        List<AlunoRespDTO> alunosRespDTOResult = this.alunoController.findAllAlunos();
        assertTrue(!alunosRespDTOResult.isEmpty());
        assertEquals(mvcResult.getResponse().getStatus(), 200);
    }
    @Test
    @DisplayName("findAllAlunos_lista_vazia, deve retornar uma lista vazia e status 200")
    void findAllAlunos_lista_vazia() throws Exception {
        Mockito.when(this.alunoController.findAllAlunos()).thenReturn(Arrays.asList());
        MvcResult mvcResult = new UtilTest().findAllAlunos_get200(mockMvc,urlBase);
        List<AlunoRespDTO> alunosRespDTOResult = this.alunoController.findAllAlunos();
        assertTrue(alunosRespDTOResult.isEmpty());
        assertEquals(mvcResult.getResponse().getStatus(), 200);

    }
}
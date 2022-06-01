package com.anderson.controller.util;

import com.anderson.model.AlunoReqDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UtilTest {
    ObjectMapper objectMapper = new ObjectMapper();
    public MvcResult generic_post201(MockMvc mockMvc, String url, AlunoReqDTO  alunoReqDTO) throws Exception {

        MvcResult result = mockMvc.perform(post(url)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(alunoReqDTO)))
                .andExpect(status().is(201))
                .andReturn();
        return result;

    }
    public MvcResult generic_post400(MockMvc mockMvc, String url, AlunoReqDTO  alunoReqDTO) throws Exception {

        MvcResult result = mockMvc.perform(post(url)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(alunoReqDTO)))
                .andExpect(status().is(400))
                .andReturn();
        return result;

    }

}

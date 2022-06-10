package com.anderson.controller.util;

import com.anderson.model.AlunoReqDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UtilTest {
    ObjectMapper objectMapper = new ObjectMapper();
    public MvcResult create_post201(MockMvc mockMvc, String url, AlunoReqDTO  alunoReqDTO) throws Exception {
        return mockMvc.perform(post(url)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(alunoReqDTO)))
                .andExpect(status().is(201))
                .andReturn();

    }
    public MvcResult create_post400(MockMvc mockMvc, String url, AlunoReqDTO  alunoReqDTO) throws Exception {
        return mockMvc.perform(post(url)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(alunoReqDTO)))
                .andExpect(status().is(400))
                .andReturn();

    }
    public MvcResult generic_get200(MockMvc mockMvc, String url, Object object) throws Exception {
            return mockMvc.perform(get(url,object)
                            .contentType("application/json"))
                    .andExpect(status().is(200))
                    .andReturn();
    }
    public MvcResult generic_get404(MockMvc mockMvc, String url, Object object) throws Exception {
        return mockMvc.perform(get(url,object)
                        .contentType("application/json"))
                .andExpect(status().is(404))
                .andReturn();
    }
    public MvcResult generic_post400(MockMvc mockMvc, String url, AlunoReqDTO  alunoReqDTO) throws Exception {
        return mockMvc.perform(post(url)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(alunoReqDTO)))
                .andExpect(status().is(400))
                .andReturn();
    }

}

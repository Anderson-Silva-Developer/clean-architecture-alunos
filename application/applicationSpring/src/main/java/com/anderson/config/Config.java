package com.anderson.config;

import com.anderson.CreateAluno;
import com.anderson.FindAluno;
import com.anderson.SpringConfig;
import com.anderson.controller.AlunoController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private final SpringConfig config = new SpringConfig();

    @Bean
    public CreateAluno createAluno(){
        return config.createAluno();
    }
    @Bean
    public FindAluno  findAluno(){
        return config.findAluno();
    }
    @Bean
    public AlunoController alunoController(){
        return new AlunoController(createAluno(),findAluno());
    }
}

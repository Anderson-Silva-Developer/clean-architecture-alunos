package com.anderson.config;


import com.anderson.SpringConfig;
import com.anderson.controller.AlunoController;
import com.anderson.repository.AlunoRepositorySpring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public AlunoRepositorySpring alunoRepositorySpring(){
        return new AlunoRepositorySpring();
    }

    public  SpringConfig springConfig(){
        return new SpringConfig(alunoRepositorySpring());
    }
    @Bean
    public AlunoController alunoController(){
        return new AlunoController(springConfig().alunoUsecaseServiceImpl());
    }
}

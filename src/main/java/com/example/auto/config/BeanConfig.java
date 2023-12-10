package com.example.auto.config;

import com.example.auto.dtos.AllModelDto;
import com.example.auto.models.entities.Models;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}

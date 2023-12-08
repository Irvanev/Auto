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

/*@Configuration
public class BeanConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Models.class, AllModelDto.class)
                .addMapping(Models::getBrands, AllModelDto::setBrandName);

        return modelMapper;
    }
}*/

package com.example.auto.services.impl;

import com.example.auto.dtos.AddModelDto;
import com.example.auto.dtos.AllModelDto;
import com.example.auto.dtos.ShowModelInfoDto;
import com.example.auto.models.entities.Models;
import com.example.auto.models.enums.CategoryEnum;
import com.example.auto.repositories.BrandRepository;
import com.example.auto.repositories.ModelRepository;
import com.example.auto.services.ModelsService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelsService {
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addModel(AddModelDto addModelDto) {
        addModelDto.setCreated(LocalDateTime.now());
        addModelDto.setModified(LocalDateTime.now());
        Models model = modelMapper.map(addModelDto, Models.class);
        model.setBrands(brandRepository.findByName(addModelDto.getBrandName()).orElse(null));
        modelRepository.saveAndFlush(model);
    }
    @Override
    public void removeModel(String id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<AllModelDto> allModels() {
        modelMapper.typeMap(Models.class, AllModelDto.class)
                .addMapping(Models::getBrands, AllModelDto::setBrandName);
        return modelRepository.findAll().stream().map(model -> modelMapper.map(model, AllModelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AllModelDto> allModelsByCategory(CategoryEnum category) {
        modelMapper.typeMap(Models.class, AllModelDto.class)
                .addMapping(Models::getBrands, AllModelDto::setBrandName);
        return modelRepository.findByCategory(category).stream().map(model -> modelMapper.map(model, AllModelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShowModelInfoDto showModelInfo(String id) {
        modelMapper.typeMap(Models.class, ShowModelInfoDto.class)
                .addMapping(Models::getBrands, ShowModelInfoDto::setBrandName);
        return modelMapper.map(modelRepository.findById(id), ShowModelInfoDto.class);
    }

    @Override
    public List<Models> searchModels(String brand, String model) {
        return modelRepository.findByBrandsNameAndName(brand, model);
    }
}

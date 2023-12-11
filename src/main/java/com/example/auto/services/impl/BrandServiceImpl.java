package com.example.auto.services.impl;

import com.example.auto.dtos.AddBrandDto;
import com.example.auto.dtos.AllBrandDto;
import com.example.auto.models.entities.Brands;
import com.example.auto.repositories.BrandRepository;
import com.example.auto.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelMapper modelMapper;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(ModelMapper modelMapper, BrandRepository brandRepository) {
        this.modelMapper = modelMapper;
        this.brandRepository = brandRepository;
    }

    @Override
    public void addBrand(AddBrandDto addBrandDto) {
        addBrandDto.setCreated(LocalDateTime.now());
        addBrandDto.setModified(LocalDateTime.now());
        Brands brands = modelMapper.map(addBrandDto, Brands.class);
        brandRepository.saveAndFlush(brands);
    }

    @Override
    public void removeBrand(String name) {
        brandRepository.deleteByName(name);
    }

    @Override
    public List<AllBrandDto> allBrands() {
        return brandRepository.findAll().stream().map(brand -> modelMapper.map(brand, AllBrandDto.class))
                .collect(Collectors.toList());
    }
}

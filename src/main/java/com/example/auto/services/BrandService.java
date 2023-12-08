package com.example.auto.services;

import com.example.auto.dtos.AddBrandDto;
import com.example.auto.dtos.AllBrandDto;

import java.util.List;

public interface BrandService {
    public void addBrand(AddBrandDto addBrandDto);
    public List<AllBrandDto> allBrands();
    public void removeBrand(String name);
}

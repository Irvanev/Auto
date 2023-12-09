package com.example.auto.services;

import com.example.auto.dtos.AddModelDto;
import com.example.auto.dtos.AllModelDto;
import com.example.auto.dtos.ShowModelInfoDto;
import com.example.auto.models.entities.Models;
import com.example.auto.models.enums.CategoryEnum;

import java.util.List;

public interface ModelsService {
    public void addModel(AddModelDto addModelDto);
    public void removeModel(String id);
    public List<AllModelDto> allModels();
    public List<AllModelDto> allModelsByCategory(CategoryEnum category);
    public ShowModelInfoDto showModelInfo(String id);
    public List<Models> searchModels(String brand, String model);
}

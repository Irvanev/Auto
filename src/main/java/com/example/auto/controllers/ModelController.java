package com.example.auto.controllers;

import com.example.auto.dtos.AddModelDto;
import com.example.auto.dtos.AllModelDto;
import com.example.auto.models.entities.Models;
import com.example.auto.models.enums.CategoryEnum;
import com.example.auto.services.BrandService;
import com.example.auto.services.ModelsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/models")
public class ModelController {
    private ModelsService modelService;
    private BrandService brandService;

    @Autowired
    public void setModelService(ModelsService modelService, BrandService brandService) {
        this.modelService = modelService;
        this.brandService = brandService;
    }

    @ModelAttribute("modelsModel")
    public AddModelDto initModel() {
        return new AddModelDto();
    }

    @GetMapping("/all")
    public String getAllModels(Model model) {
        model.addAttribute("models", modelService.allModels());
        model.addAttribute("brands", brandService.allBrands());
        return "models";
    }

    @GetMapping("/add")
    public String addModel(Model model) {
        model.addAttribute("availableBrands", brandService.allBrands());
        return "addModel";
    }

    @PostMapping("/add")
    public String addModel(@Valid AddModelDto addModelDto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("modelsModel", addModelDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.modelsModel",
                    result);
            return "redirect:/models/add";
        }
        modelService.addModel(addModelDto);
        return "redirect:/models/all";
    }

    @GetMapping("/category/{category}")
    public String getModelsByCategory(@PathVariable CategoryEnum category, Model model) {
        List<AllModelDto> models = modelService.allModelsByCategory(category);
        model.addAttribute("models", models);
        model.addAttribute("brands", brandService.allBrands());
        return "models";
    }

    @GetMapping("/modelDelete/{id}")
    public String removeModel(@PathVariable("id") String id) {
        modelService.removeModel(id);

        return "redirect:/models/all";
    }

    @GetMapping("/modelDetails/{id}")
    public String showModelInfo(@PathVariable("id") String id, Model model) {
        model.addAttribute("modelInfo", modelService.showModelInfo(id));

        return "showModelDetail";
    }

    @GetMapping("/models/search")
    public List<Models> searchModels(@RequestParam String brand, @RequestParam String model) {
        return modelService.searchModels(brand, model);
    }

    @GetMapping("/edit/{id}")
    public String editModel(@PathVariable("id") String id, Model model) {
        model.addAttribute("model", modelService.showModelInfo(id));
        model.addAttribute("availableBrands", brandService.allBrands());
        return "editModel";
    }
    @PostMapping("/edit/{id}")
    public String editModel(@PathVariable String id, @Valid AddModelDto addModelDto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("modelsModel", addModelDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.modelsModel",
                    result);
            return "redirect:/models/edit/{id}";
        }
        modelService.editModel(id, addModelDto);
        return "redirect:/models/all";
    }
}

package com.example.auto.controllers;

import com.example.auto.dtos.AddBrandDto;
import com.example.auto.services.BrandService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private static final Logger LOG = LogManager.getLogger(Controller.class);
    private BrandService brandService;

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @ModelAttribute("brandsModel")
    public AddBrandDto initBrand() {
        return new AddBrandDto();
    }

    @GetMapping("/all")
    public String getAllBrands(Model model, Principal principal) {
        LOG.log(Level.INFO, "Show all brands for Admin: " + principal.getName());
        model.addAttribute("brands", brandService.allBrands());
        return "brands";
    }

    @GetMapping("/add")
    public String addBrand() {
        return "addBrand";
    }

    @PostMapping("/add")
    public String addBrand(@Valid AddBrandDto addBrandDto, BindingResult result, RedirectAttributes attributes, Principal principal) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("brandsModel", addBrandDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.brandsModel",
                    result);
            return "redirect:/brands/add";
        }
        LOG.log(Level.INFO, "Add new brand by " + principal.getName());
        brandService.addBrand(addBrandDto);
        return "redirect:/brands/all";
    }

    @GetMapping("/delete/{name}")
    public String removeBrand(@PathVariable("name") String name, Principal principal) {
        LOG.log(Level.INFO, "Delete " + name + " brand by " + principal.getName());
        brandService.removeBrand(name);
        return "redirect:/brands/all";
    }
}

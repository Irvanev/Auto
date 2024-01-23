package com.example.auto.controllers;

import com.example.auto.dtos.AddModelDto;
import com.example.auto.dtos.AddOfferDto;
import com.example.auto.dtos.ShowModelInfoDto;
import com.example.auto.models.entities.Offers;
import com.example.auto.models.entities.Users;
import com.example.auto.services.ModelsService;
import com.example.auto.services.OfferService;
import com.example.auto.services.UserService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private OfferService offerService;
    private ModelsService modelService;
    private UserService userService;

    @Autowired
    public void setOfferService(OfferService offerService, ModelsService modelService, UserService userService) {
        this.offerService = offerService;
        this.modelService = modelService;
        this.userService = userService;
    }

    @ModelAttribute("offersModel")
    public AddOfferDto initOffer() {
        return new AddOfferDto();
    }

    @GetMapping("/all")
    public String getAllBrands(Model model) {
        model.addAttribute("offers", offerService.allOffers());
        return "offers";
    }

    @PostMapping("/buy")
    public String buyOffer(@ModelAttribute("offersModel") @Valid AddOfferDto addOfferDto, BindingResult bindingResult, Principal principal, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }
        offerService.addOffer(addOfferDto, principal);
        redirectAttributes.addFlashAttribute("successMessage", "Offer created successfully");
        return "redirect:/";
    }
}

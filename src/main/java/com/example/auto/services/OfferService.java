package com.example.auto.services;

import com.example.auto.dtos.AddOfferDto;
import com.example.auto.dtos.AllBrandDto;
import com.example.auto.dtos.AllOffersDto;

import java.security.Principal;
import java.util.List;

public interface OfferService {
    void addOffer(AddOfferDto addOfferDto, Principal principal);
    public List<AllOffersDto> allOffers();
}

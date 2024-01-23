package com.example.auto.services.impl;

import com.example.auto.dtos.AddOfferDto;
import com.example.auto.dtos.AllBrandDto;
import com.example.auto.dtos.AllModelDto;
import com.example.auto.dtos.AllOffersDto;
import com.example.auto.models.entities.Models;
import com.example.auto.models.entities.Offers;
import com.example.auto.models.enums.OfferEnum;
import com.example.auto.repositories.ModelRepository;
import com.example.auto.repositories.OfferRepository;
import com.example.auto.repositories.UserRepository;
import com.example.auto.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final OfferRepository offerRepository;

    public OfferServiceImpl(ModelMapper modelMapper, ModelRepository modelRepository, UserRepository userRepository,
                            OfferRepository offerRepository) {
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
    }
    @Override
    public void addOffer(AddOfferDto addOfferDto, Principal principal) {
        Offers offer = modelMapper.map(addOfferDto, Offers.class);
        offer.setModified(LocalDateTime.now());
        offer.setStatus(OfferEnum.Created);
        offer.setCreated(LocalDateTime.now());
        offerRepository.save(offer);
    }

    @Override
    public List<AllOffersDto> allOffers() {
        modelMapper.typeMap(Offers.class, AllOffersDto.class)
                .addMapping(Offers::getModels, AllOffersDto::setModelName);
        modelMapper.typeMap(Offers.class, AllOffersDto.class)
                .addMapping(Offers::getUsers, AllOffersDto::setUserName);
        return offerRepository.findAll().stream().map(offers -> modelMapper.map(offers, AllOffersDto.class))
                .collect(Collectors.toList());
    }
}

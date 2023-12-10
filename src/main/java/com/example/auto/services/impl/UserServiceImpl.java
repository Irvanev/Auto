package com.example.auto.services.impl;

import com.example.auto.dtos.AllBrandDto;
import com.example.auto.dtos.AllModelDto;
import com.example.auto.dtos.AllUserDto;
import com.example.auto.dtos.UserRegistrationDto;
import com.example.auto.models.entities.Models;
import com.example.auto.models.entities.Users;
import com.example.auto.models.enums.RoleEnum;
import com.example.auto.repositories.RoleRepository;
import com.example.auto.repositories.UserRepository;
import com.example.auto.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public void addUser(UserRegistrationDto userRegistrationDto) {
        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }
        Optional<Users> byUsername = this.userRepository.findByUsername(userRegistrationDto.getUsername());

        if (byUsername.isPresent()) {
            throw new RuntimeException("login.used");
        }
        var role = roleRepository.
                findByRoleName(RoleEnum.User).orElseThrow();

        Users user = new Users(
                userRegistrationDto.getUsername(),
                passwordEncoder.encode(userRegistrationDto.getPassword()),
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getImageURL()
        );
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setRole(role);

        this.userRepository.save(user);
    }
    @Override
    public Users getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }

    @Override
    public List<AllUserDto> allUsers() {
        modelMapper.typeMap(Users.class, AllUserDto.class)
                .addMapping(Users::getUsername, AllUserDto::setUsername);
        return userRepository.findAll().stream().map(users -> modelMapper.map(users, AllUserDto.class))
                .collect(Collectors.toList());
    }
}

package com.example.auto.services;

import com.example.auto.dtos.AllUserDto;
import com.example.auto.dtos.UserRegistrationDto;
import com.example.auto.models.entities.Users;

import java.util.List;

public interface UserService {
    public void addUser(UserRegistrationDto userRegistrationDto);
    public Users getUser(String username);
    public List<AllUserDto> allUsers();
    public void editUser(String username, UserRegistrationDto userRegistrationDto);
}

package com.example.auto.controllers;

import com.example.auto.dtos.UserProfileView;
import com.example.auto.dtos.UserRegistrationDto;
import com.example.auto.models.entities.Offers;
import com.example.auto.models.entities.Users;
import com.example.auto.services.UserService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/users")
public class AuthenticationController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userRegistration")
    public UserRegistrationDto initForm() {
        return new UserRegistrationDto();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegistrationDto userRegistrationDto, BindingResult result,
                             RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto", result);

            return "redirect:/users/register";
        }
        this.userService.addUser(userRegistrationDto);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String login,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, login);
        redirectAttributes.addFlashAttribute("badCredentials", true);

        return "redirect:/users/login";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        String username = principal.getName();
        Users user = userService.getUser(username);

        UserProfileView userProfileView = new UserProfileView(
                username,
                user.getFirstName(),
                user.getLastName(),
                user.getImageURL()
        );

        model.addAttribute("user", userProfileView);
        List<Offers> offers = userService.getUserOrders(username);
        model.addAttribute("offers", offers);

        return "profile";
    }

    @GetMapping("/all")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @GetMapping("/edit/{username}")
    public String editUser(@PathVariable String username, Model model) {
        model.addAttribute("user", userService.getUser(username));
        return "editUser";
    }

    @PostMapping("/edit/{username}")
    public String editUser(@PathVariable String username, @Valid UserRegistrationDto userRegistrationDto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto", result);

            return "redirect:/users/edit/{username}";
        }
        this.userService.editUser(username, userRegistrationDto);
        return "redirect:/models/all";
    }
}

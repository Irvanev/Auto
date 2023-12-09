package com.example.auto.services.impl;

import com.example.auto.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.stream.Collectors;

public class AppUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(u -> {
                    String password = u.getPassword();
                    String roleName = u.getRole().getRoleName().name();

                    if (username == null || username.isEmpty()) {
                        throw new IllegalArgumentException("Username cannot be null or empty");
                    }

                    if (password == null || password.isEmpty()) {
                        throw new IllegalArgumentException("Password cannot be null or empty");
                    }

                    if (roleName == null || roleName.isEmpty()) {
                        throw new IllegalArgumentException("Role cannot be null or empty");
                    }

                    return new User(
                            username,
                            password,
                            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roleName))
                    );
                })
                .orElseThrow(() -> new UsernameNotFoundException(username + "User not found"));
    }
}

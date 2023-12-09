//package com.example.auto;
//
//import com.example.auto.models.entities.Roles;
//import com.example.auto.models.entities.Users;
//import com.example.auto.models.enums.RoleEnum;
//import com.example.auto.repositories.RoleRepository;
//import com.example.auto.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Component
//public class Init implements CommandLineRunner {
//    private final UserRepository userRepository;
//
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final String defaultPassword;
//
//    public Init(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, @Value("${app.default.password}") String defaultPassword) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.defaultPassword = defaultPassword;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        initRoles();
//        initUsers();
//    }
//
//    private void initRoles() {
//        if (roleRepository.count() == 0) {
//            var adminRole = new Roles(RoleEnum.Admin);
//            var normalUserRole = new Roles(RoleEnum.User);
//            roleRepository.save(adminRole);
//            roleRepository.save(normalUserRole);
//        }
//    }
//
//    private void initUsers() {
//        if (userRepository.count() == 0) {
//            initAdmin();
//        }
//    }
//
//    private void initAdmin(){
//       var adminRole = roleRepository.
//                findByRoleName(RoleEnum.Admin).orElseThrow();
//
//       var adminUser = new Users("Irvvanevv", passwordEncoder.encode(defaultPassword), "Adminka", "Adminovich", "https://jbrfejwdnckjnjwknjkcee");
//       adminUser.setRole(adminRole);
//       adminUser.setCreated(LocalDateTime.now());
//       adminUser.setModified(LocalDateTime.now());
//
//       userRepository.save(adminUser);
//    }
//}

package com.example.testdeveloppeursstagiairespolyvalent.service.impl;

import com.example.testdeveloppeursstagiairespolyvalent.entity.UserModel;
import com.example.testdeveloppeursstagiairespolyvalent.repository.UserRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OnStartService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    @PostConstruct
    @Bean
    public void initRoleAndUser() {
        UserModel adminUser = new UserModel();
        adminUser.setId((long) 1);
        adminUser.setUserName("admin");
        adminUser.setFullName("admin FullName ");
        adminUser.setEmail("admin@gmail.com");
        adminUser.setPassword(passwordEncoder.encode("12345"));
        userRepo.save(adminUser);
    }
}

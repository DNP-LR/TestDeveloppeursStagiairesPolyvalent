package com.example.testdeveloppeursstagiairespolyvalent.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName", length = 60, unique = true)
    private String userName;

    @Column(name = "fullName", length = 30)
    private String fullName;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @NotNull
    @Column(name = "password", length = 60)
    @Size(min = 60, max = 60)
    private String password;


    @Email
    @Size(min = 5, max = 100)
    @Column(name = "email", length = 100, unique = true)
    private String email;

//    @OneToMany(mappedBy = "user")
//    private List<Role> roles;


    @PrePersist
    void persist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void update() {
        updatedAt = LocalDateTime.now();
    }
}

package com.example.testdeveloppeursstagiairespolyvalent.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Books {
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookName", length = 60, unique = true)
    private String bookName;

    @Column(name = "bookDescription", length = 60)
    private String bookDescription;
    @Column(name = "bookType", length = 60)
    private String bookType;

    @Column(name = "createdAt")
    private LocalDateTime createAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;


    @PrePersist
    void persist() {
        createAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void update() {
        updatedAt = LocalDateTime.now();
    }
}

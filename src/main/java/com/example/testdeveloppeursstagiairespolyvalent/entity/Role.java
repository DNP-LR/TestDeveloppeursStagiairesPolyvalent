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
@Table(name = "userRole")
public class Role {
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roleName", length = 60, unique = true)
    private String roleName;

    @Column(name = "roleDescription", length = 60)
    private String roleDescription;

    @Column(name = "createdAt")
    private LocalDateTime createAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

//    @OneToMany(mappedBy = "role")
//    @JsonIgnore
//    private List<User> user;

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

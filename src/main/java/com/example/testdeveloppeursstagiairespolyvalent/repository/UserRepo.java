package com.example.testdeveloppeursstagiairespolyvalent.repository;

import com.example.testdeveloppeursstagiairespolyvalent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);
}

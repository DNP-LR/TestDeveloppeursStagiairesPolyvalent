package com.example.testdeveloppeursstagiairespolyvalent.repository;

import com.example.testdeveloppeursstagiairespolyvalent.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserModel, Long>, JpaSpecificationExecutor<UserModel> {
    Optional<UserModel> findByUserName(String userName);

    Optional<UserModel> findByEmail(String email);
}

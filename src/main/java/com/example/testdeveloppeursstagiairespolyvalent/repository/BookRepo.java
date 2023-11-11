package com.example.testdeveloppeursstagiairespolyvalent.repository;

import com.example.testdeveloppeursstagiairespolyvalent.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Books, Long>, JpaSpecificationExecutor<Books> {
    Optional<Books> findByBookName(String bookName);

    Optional<Books> findByBookType(String bookType);
}

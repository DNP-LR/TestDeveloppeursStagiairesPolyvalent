package com.example.testdeveloppeursstagiairespolyvalent.specification;

import com.example.testdeveloppeursstagiairespolyvalent.criteria.BookCriteria;
import com.example.testdeveloppeursstagiairespolyvalent.entity.Books;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public final class BookSpecification {

    private static Specification<Books> withBookName(String bookName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("bookName"), "%".concat(bookName).concat("%"));
    }

    private static Specification<Books> withBookType(String bookType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("bookType"), "%".concat(bookType).concat("%"));
    }

    private static Specification<Books> orderByIdDesc() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id"))).getRestriction();
    }


    public static Specification<Books> getSpecification(BookCriteria criteria) {
        Specification<Books> specification = null;
        specification = Objects.requireNonNull(Specification.where(specification)).and(orderByIdDesc());
        if (criteria.getBookName() != null) {
            specification = Objects.requireNonNull(Specification.where(specification)).and(withBookName(criteria.getBookName()));
        }
        if (criteria.getBookType() != null) {
            specification = Objects.requireNonNull(Specification.where(specification)).and(withBookType(criteria.getBookType()));
        }
        return specification;
    }
}

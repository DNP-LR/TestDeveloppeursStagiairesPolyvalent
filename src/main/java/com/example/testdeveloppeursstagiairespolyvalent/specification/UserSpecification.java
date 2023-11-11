package com.example.testdeveloppeursstagiairespolyvalent.specification;

import com.example.testdeveloppeursstagiairespolyvalent.criteria.UserCriteria;
import com.example.testdeveloppeursstagiairespolyvalent.entity.UserModel;
import org.springframework.data.jpa.domain.Specification;
import java.util.Objects;

public final class UserSpecification {
    private static Specification<UserModel> withUserName(String userName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("userName"), "%".concat(userName).concat("%"));
    }

    private static Specification<UserModel> withEmail(String email) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("email"), "%".concat(email).concat("%"));

    }

    private static Specification<UserModel> withFullName(String fullName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("fullName"), "%".concat(fullName).concat("%"));
    }

    private static Specification<UserModel> orderByIdDesc() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id"))).getRestriction();
    }


    public static Specification<UserModel> getSpecification(UserCriteria userCriteria) {
        Specification<UserModel> specification = null;

        specification = Objects.requireNonNull(Specification.where(specification)).and(orderByIdDesc());

        if (userCriteria.getUserName() != null) {
            specification = Objects.requireNonNull(Specification.where(specification)).and(withUserName(userCriteria.getUserName()));
        }
        if (userCriteria.getFullName() != null) {
            specification = Objects.requireNonNull(Specification.where(specification)).and(withFullName(userCriteria.getFullName()));
        }
        if (userCriteria.getEmail() != null) {
            specification = Objects.requireNonNull(Specification.where(specification)).and(withEmail(userCriteria.getEmail()));
        }


        return specification;
    }
}

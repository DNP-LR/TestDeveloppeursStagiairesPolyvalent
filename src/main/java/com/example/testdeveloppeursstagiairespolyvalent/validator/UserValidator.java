package com.example.testdeveloppeursstagiairespolyvalent.validator;

import com.example.testdeveloppeursstagiairespolyvalent.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public static List<String> validate(UserDto userDto) {
        List<String> errors = new ArrayList<>();

        if (userDto == null) {
            errors.add("enter user full name");
            return errors;
        }
        if (!StringUtils.hasLength(userDto.getFullName())) {
            errors.add("Enter user Full Name");
        }
        if (!StringUtils.hasLength(userDto.getEmail())) {
            errors.add("Enter user Mail");
        }
        if (!StringUtils.hasLength(userDto.getUserName())) {
            errors.add("Enter user Name");
        }
        return errors;

    }
}

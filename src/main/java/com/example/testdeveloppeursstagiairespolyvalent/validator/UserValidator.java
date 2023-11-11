package com.example.testdeveloppeursstagiairespolyvalent.validator;

import com.example.testdeveloppeursstagiairespolyvalent.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public static List<String> validate(UserDto userDto) {
        List<String> errors = new ArrayList<>();

        if (userDto == null) {
            errors.add("enter user Information name");
            return errors;
        }

        if (StringUtils.isEmpty(userDto.getUserName())) {
            errors.add("Username cannot be empty");
        }

        if (StringUtils.isEmpty(userDto.getFullName())) {
            errors.add("Full name cannot be empty");
        }

        if (StringUtils.isEmpty(userDto.getEmail())) {
            errors.add("Email cannot be empty");
        }
        if (StringUtils.isEmpty(userDto.getPassword())) {
            errors.add("Password cannot be empty");
        }

        return errors;

    }


}

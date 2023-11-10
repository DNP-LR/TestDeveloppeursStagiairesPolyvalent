package com.example.testdeveloppeursstagiairespolyvalent.mapper;

import com.example.testdeveloppeursstagiairespolyvalent.dto.UserDto;
import com.example.testdeveloppeursstagiairespolyvalent.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {


    public static UserDto fromEntity(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        user.setId(user.getId());
        user.setUserName(user.getUserName());
        user.setEmail(user.getEmail());
        user.setFullName(user.getFullName());
        user.setCreatedAt(user.getCreatedAt());
        user.setUpdatedAt(user.getUpdatedAt());
        return userDto;
    }

    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();

        user.setId(userDto.getId());
        user.setUserName(user.getUserName());
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setCreatedAt(userDto.getCreatedAt());
        user.setUpdatedAt(userDto.getUpdatedAt());
        return user;
    }

    public static List<UserDto> fromEntities(List<User> entities) {
        List<UserDto> dtos = new ArrayList<>();

        for (User entity : entities) {
            dtos.add(fromEntity(entity));
        }
        return dtos;
    }

}

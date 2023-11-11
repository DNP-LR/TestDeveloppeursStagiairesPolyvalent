package com.example.testdeveloppeursstagiairespolyvalent.mapper;

import com.example.testdeveloppeursstagiairespolyvalent.dto.UserDto;
import com.example.testdeveloppeursstagiairespolyvalent.entity.UserModel;
import com.example.testdeveloppeursstagiairespolyvalent.util.DateToStringUtil;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {


    public static UserDto fromEntity(UserModel userModel) {
        if (userModel == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(userModel.getId());
        userDto.setUserName(userModel.getUserName());
        userDto.setEmail(userModel.getEmail());
//        userDto.setPassword(userModel.getPassword());
        userDto.setFullName(userModel.getFullName());
        userDto.setCreatedAt(userModel.getCreatedAt());
        userDto.setCreatedAtString(DateToStringUtil.getDateToString(userModel.getCreatedAt()));
        userDto.setUpdatedAt(userModel.getUpdatedAt());
        userDto.setUpdatedAtString(DateToStringUtil.getDateToString(userModel.getUpdatedAt()));
        return userDto;
    }

    public static UserModel toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        UserModel userModel = new UserModel();

        userModel.setId(userDto.getId());
        userModel.setUserName(userDto.getUserName());
        userModel.setFullName(userDto.getFullName());
        userModel.setEmail(userDto.getEmail());
//        userModel.setPassword(userDto.getPassword());
        userModel.setCreatedAt(userDto.getCreatedAt());
        userModel.setUpdatedAt(userDto.getUpdatedAt());
        return userModel;
    }

    public static List<UserDto> fromEntities(List<UserModel> entities) {
        List<UserDto> dtos = new ArrayList<>();

        for (UserModel entity : entities) {
            dtos.add(fromEntity(entity));
        }
        return dtos;
    }

}

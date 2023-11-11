package com.example.testdeveloppeursstagiairespolyvalent.service;

import com.example.testdeveloppeursstagiairespolyvalent.criteria.UserCriteria;
import com.example.testdeveloppeursstagiairespolyvalent.dto.UserDto;
import com.example.testdeveloppeursstagiairespolyvalent.entity.UserModel;
import com.example.testdeveloppeursstagiairespolyvalent.util.MessageNotification;

import java.util.List;

public interface UserService {
    UserModel findByUserName(String userName);

    UserModel findUserById(Long id);

    UserModel findUserByEMail(String email);
    UserDto addUser(UserDto userDto);

    List<UserDto> listAllUserWithCriteria(UserCriteria criteria);

    MessageNotification updateUserInfo(UserDto userDto, Long id);

}

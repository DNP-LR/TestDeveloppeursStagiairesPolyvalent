package com.example.testdeveloppeursstagiairespolyvalent.service;

import com.example.testdeveloppeursstagiairespolyvalent.criteria.UserCriterial;
import com.example.testdeveloppeursstagiairespolyvalent.dto.UserDto;
import com.example.testdeveloppeursstagiairespolyvalent.entity.User;

import java.util.List;

public interface UserService {
    User findByUserName(String userName);

    UserDto saveUser(UserDto userDto);

    List<UserDto> listAllUserWithCriteria(UserCriterial criterial);

}

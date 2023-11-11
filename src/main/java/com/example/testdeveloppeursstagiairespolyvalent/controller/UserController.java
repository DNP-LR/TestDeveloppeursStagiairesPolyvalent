package com.example.testdeveloppeursstagiairespolyvalent.controller;

import com.example.testdeveloppeursstagiairespolyvalent.controller.api.UserApi;
import com.example.testdeveloppeursstagiairespolyvalent.criteria.UserCriteria;
import com.example.testdeveloppeursstagiairespolyvalent.dto.UserDto;
import com.example.testdeveloppeursstagiairespolyvalent.service.UserService;
import com.example.testdeveloppeursstagiairespolyvalent.util.MessageNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;

    @Override
    public MessageNotification updateUserInfo(Long id, UserDto userDto) {
        return userService.updateUserInfo(userDto, id);
    }

    @Override
    public List<UserDto> listAllUsersWithCriteria(String userName, String fullName, String email, Integer limit) {
        return userService.listAllUserWithCriteria(new UserCriteria(userName, fullName, email, limit));
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        return userService.addUser(userDto);
    }
}

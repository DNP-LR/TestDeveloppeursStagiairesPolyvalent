package com.example.testdeveloppeursstagiairespolyvalent.controller.api;

import com.example.testdeveloppeursstagiairespolyvalent.dto.UserDto;
import com.example.testdeveloppeursstagiairespolyvalent.util.MessageNotification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.testdeveloppeursstagiairespolyvalent.util.EndPointConstantUtil.USER_END_POINT;

public interface UserApi {

    @GetMapping(value = USER_END_POINT + "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> listAllUsersWithCriteria(
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "fullName", required = false) String fullName,
            @RequestParam(value = "limit", required = false) Integer limit    );

    @PostMapping(value = USER_END_POINT + "/add")
    UserDto addUser(@RequestBody UserDto userDto);

    @PutMapping(value = USER_END_POINT + "/update")
    MessageNotification updateUserInfo(
            @RequestParam(value = "id", required = true) Long id,
            @RequestBody UserDto userDto);
}

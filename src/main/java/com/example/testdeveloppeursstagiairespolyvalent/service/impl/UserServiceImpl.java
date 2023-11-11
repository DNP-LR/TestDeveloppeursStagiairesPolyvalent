package com.example.testdeveloppeursstagiairespolyvalent.service.impl;

import com.example.testdeveloppeursstagiairespolyvalent.criteria.UserCriteria;
import com.example.testdeveloppeursstagiairespolyvalent.dto.UserDto;
import com.example.testdeveloppeursstagiairespolyvalent.entity.UserModel;
import com.example.testdeveloppeursstagiairespolyvalent.exception.ErrorCodes;
import com.example.testdeveloppeursstagiairespolyvalent.exception.InvalidEntityException;
import com.example.testdeveloppeursstagiairespolyvalent.mapper.UserMapper;
import com.example.testdeveloppeursstagiairespolyvalent.repository.UserRepo;
import com.example.testdeveloppeursstagiairespolyvalent.service.UserService;
import com.example.testdeveloppeursstagiairespolyvalent.specification.UserSpecification;
import com.example.testdeveloppeursstagiairespolyvalent.util.MessageNotification;
import com.example.testdeveloppeursstagiairespolyvalent.util.MethodUtil;
import com.example.testdeveloppeursstagiairespolyvalent.validator.UserValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.testdeveloppeursstagiairespolyvalent.util.TranslationConstantUtil.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserModel findUserByEMail(String email) {
        if (email == null) {
            throw new NullPointerException(ID_CAN_NOT_BE_NULL);
        }
        Optional<UserModel> user = userRepo.findByEmail(email);
        return user.orElse(null);
    }

    @Override
    public UserModel findUserById(Long id) {
        if (id == null) {
            throw new NullPointerException(ID_CAN_NOT_BE_NULL);
        }
        Optional<UserModel> userModel = userRepo.findById(id);
        if (userModel.isEmpty()) {
            throw new EntityNotFoundException(USER_NOT_FOUND_WITH_THIS_ID);
        }
        return userModel.get();
    }

    @Override
    public UserModel findByUserName(String userName) {
        if (userName == null) {
            throw new NullPointerException(USERNAME_CAN_NOT_BE_NULL);
        }
        Optional<UserModel> userModel = userRepo.findByUserName(userName);
        return userModel.orElse(null);
    }


    @Override
    public UserDto addUser(UserDto userDto) {
        List<String> errors = UserValidator.validate(userDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException(INVALID_REQUEST, ErrorCodes.USER_NOT_VALID, errors);
        }

        UserModel userModel = UserMapper.toEntity(userDto);
        List<String> errorExist = checkIfUserWithInfoExist(userModel);
        if (!errorExist.isEmpty()) {
            throw new InvalidEntityException(INVALID_REQUEST, ErrorCodes.USER_NOT_VALID, errorExist);
        }
        if (userModel == null) {
            throw new EntityNotFoundException(INVALID_REQUEST);
        }


        userModel.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserModel saveUser = userRepo.save(userModel);
        return UserMapper.fromEntity(saveUser);
    }

    @Override
    public MessageNotification updateUserInfo(UserDto userDto, Long id) {

        List<String> error = UserValidator.validate(userDto);
        if (!error.isEmpty()) {
            throw new InvalidEntityException(INVALID_REQUEST, ErrorCodes.USER_NOT_VALID, error);
        }

        UserModel userModel = getUserIfExists(id);

        if (!isEmailUnique(userDto.getEmail(), userModel)) {
            throw new InvalidEntityException("Email is already in use");
        }

        // Check if the updated username is unique
        if (!isUsernameUnique(userDto.getUserName(), userModel)) {
            throw new InvalidEntityException("Username is already in use");
        }
        System.out.println(userModel);
        if (userModel == null) {
            throw new EntityNotFoundException("User not found with the provided ID");
        }
        userModel.setUserName(userDto.getUserName());
        userModel.setFullName(userDto.getFullName());
        userModel.setEmail(userDto.getEmail());
        userModel.setUpdatedAt(userDto.getUpdatedAt());

        userRepo.save(userModel);
        return new MessageNotification("1", "Update");
    }

    private boolean isEmailUnique(String email, UserModel currentUser) {
        // Implement the logic to check if the email is unique among all users
        Optional<UserModel> existingUser = userRepo.findByEmail(email);
        return existingUser.map(user -> user.equals(currentUser)).orElse(true);
    }

    private boolean isUsernameUnique(String username, UserModel currentUser) {
        // Implement the logic to check if the username is unique among all users
        Optional<UserModel> existingUser = userRepo.findByUserName(username);
        return existingUser.map(user -> user.equals(currentUser)).orElse(true);
    }

    private UserModel getUserIfExists(Long userId) {
        // Implement the logic to check if a user with the provided ID exists
        Optional<UserModel> existingUser = userRepo.findById(userId);
        return existingUser.orElse(null);
    }

    @Override
    public List<UserDto> listAllUserWithCriteria(UserCriteria criteria) {
        Pageable pageable = MethodUtil.findAllByCriteria(criteria.getLimit());
        return UserMapper.fromEntities(userRepo.findAll(UserSpecification.getSpecification(criteria), pageable).getContent());
    }

    public List<String> checkIfUserWithInfoExist(UserModel userModel) {
        List<String> errors = new ArrayList<>();

        if (findUserByEMail(userModel.getEmail()) != null) {
            errors.add(A_USER_ALREADY_EXIST_WITH_THIS_EMAIL);
        }
        if (findByUserName(userModel.getUserName()) != null) {
            errors.add(A_USER_ALREADY_EXIST_WITH_THIS_USERNAME);
        }

        return errors;
    }


}

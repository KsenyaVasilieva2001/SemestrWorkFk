package ru.kpfu.itis.skatingblog.services;


import org.springframework.http.ResponseEntity;
import ru.kpfu.itis.skatingblog.dto.AuthDto;
import ru.kpfu.itis.skatingblog.dto.SignUpForm;
import ru.kpfu.itis.skatingblog.dto.UserDto;
import ru.kpfu.itis.skatingblog.exceptions.DuplicateEntryException;
import ru.kpfu.itis.skatingblog.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.skatingblog.models.User;
import ru.kpfu.itis.skatingblog.models.enums.Role;
import ru.kpfu.itis.skatingblog.models.enums.Status;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User findUserById(Long id);
    void saveUser(User user);
    void deleteUserById(Long id);
    void deleteByEmail(String email);
    Optional<User> findUserByEmail(String email);
    void updateUser(String firstName, String lastName, String email);
    void registerUser(SignUpForm signUpForm) throws DuplicateEntryException;
    void login(AuthDto authDto) throws WrongEmailOrPasswordException;
    List<User> findAll();
    Optional<User> findById(Long id);
    void updateUserRoleAndStatus(Role role, Status status, Long id);
}

package ru.kpfu.itis.skatingblog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.skatingblog.dto.AuthDto;
import ru.kpfu.itis.skatingblog.dto.SignUpForm;
import ru.kpfu.itis.skatingblog.dto.UserDto;
import ru.kpfu.itis.skatingblog.exceptions.DuplicateEntryException;
import ru.kpfu.itis.skatingblog.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.skatingblog.models.User;
import ru.kpfu.itis.skatingblog.models.enums.Role;
import ru.kpfu.itis.skatingblog.models.enums.Status;
import ru.kpfu.itis.skatingblog.repositories.UserRepository;
import ru.kpfu.itis.skatingblog.services.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(new User());
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public void deleteByEmail(String email) {

    }



    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void updateUser(String newFirstName, String newLastName, String email) {
        userRepository.update(newFirstName, newLastName, email);
    }


    //пересмотреть еще раз, спросить
    @Transactional
    @Override
    public void registerUser(SignUpForm signUpForm) throws DuplicateEntryException {
        Optional<User> userOptional = findUserByEmail(signUpForm.getEmail());
        if (userOptional.isEmpty()) {
            User user = new User();
            user.setFirstName(signUpForm.getFirstName());
            user.setLastName(signUpForm.getLastName());
            user.setStatus(Status.ACTIVE);
            user.setRole(Role.USER);
            user.setEmail(signUpForm.getEmail());
            user.setPassword(encodePassword(signUpForm.getPassword()));
            saveUser(user);
            // return Optional.of(user);
          //  return new ResponseEntity(HttpStatus.OK);
        } else
            throw new DuplicateEntryException("There is an account with that email address: "
                    + signUpForm.getEmail());
    }

    @Override
    public void login(AuthDto authDto) throws WrongEmailOrPasswordException {
        /*
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(),
                authDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
        */
        Optional<User> user = findUserByEmail(authDto.getEmail());
        if (user.isPresent()) {
            if (!user.get().getPassword().equals(authDto.getPassword())) {
                throw new WrongEmailOrPasswordException();
            }
        } else throw new WrongEmailOrPasswordException();
    }

    @Override
    public List<User> findAll() {
       return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUserRoleAndStatus(Role role, Status status, Long id) {
        userRepository.updateUserRoleAndStatus(role, status, id);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

}

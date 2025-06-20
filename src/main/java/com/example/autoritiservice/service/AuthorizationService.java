package com.example.autoritiservice.service;

import com.example.autoritiservice.Authorities;
import com.example.autoritiservice.User;
import com.example.autoritiservice.exception.InvalidCredentials;
import com.example.autoritiservice.exception.UnauthorizedUser;
import com.example.autoritiservice.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorizationService {

    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User userClass) {
        String user = userClass.getUser();
        String password = userClass.getPassword();

        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

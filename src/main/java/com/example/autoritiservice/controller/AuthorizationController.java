package com.example.autoritiservice.controller;

import com.example.autoritiservice.Authorities;
import com.example.autoritiservice.User;
import com.example.autoritiservice.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {

    AuthorizationService service;

    AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}

package com.example.autoritiservice.repository;

import com.example.autoritiservice.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private String user = "Vano";
    private String password = "onaV";

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals(this.user) && password.equals(this.password)) {
            List<Authorities> userAuthorities = new ArrayList<>();
            userAuthorities.add(Authorities.READ);
            userAuthorities.add(Authorities.WRITE);
            userAuthorities.add(Authorities.DELETE);
            return userAuthorities;
        }

        return new ArrayList<>();
    }
}

package com.example.sqlinjectionhibernate.controller;

import com.example.sqlinjectionhibernate.model.User;
import com.example.sqlinjectionhibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers(@RequestParam String login) {
        return userRepository.findByLogin(login); // Защита через Hibernate
    }
}
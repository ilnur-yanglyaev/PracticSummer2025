package com.example.sqlinjectiondemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<Map<String, Object>> getUsers(@RequestParam String login) {
        String query = "SELECT * FROM users WHERE login = '" + login + "'";
        return jdbcTemplate.queryForList(query); // УЯЗВИМОСТЬ!
    }
}
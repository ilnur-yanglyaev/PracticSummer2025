package com.example.sqlinjectionsecure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<Map<String, Object>> getUsers(@RequestParam String login) {
        String query = "SELECT * FROM users WHERE login = ?";
        return jdbcTemplate.queryForList(query, login); // ПАРАМЕТРИЗОВАННЫЙ ЗАПРОС
    }
}
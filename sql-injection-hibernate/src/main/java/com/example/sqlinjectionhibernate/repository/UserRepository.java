package com.example.sqlinjectionhibernate.repository;

import com.example.sqlinjectionhibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByLogin(String login);
}
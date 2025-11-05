package com.example.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.portfolio.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}

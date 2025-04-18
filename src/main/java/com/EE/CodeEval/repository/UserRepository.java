package com.EE.CodeEval.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EE.CodeEval.model.User;



public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUsername(String username);
}

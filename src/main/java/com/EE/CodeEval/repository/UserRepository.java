package com.EE.CodeEval.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EE.CodeEval.model.UserModel;
public interface UserRepository extends JpaRepository< UserModel , Long>{
    Optional <UserModel> findByUsername(String username);
    
}

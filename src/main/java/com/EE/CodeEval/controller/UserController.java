package com.EE.CodeEval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EE.CodeEval.repository.UserRepository;


import lombok.RequiredArgsConstructor;

import com.EE.CodeEval.model.*;
import java.util.List;


@RestController
// @CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    //Get Users
    @GetMapping
    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }

    //Add User
    @PostMapping
    public UserModel createUser(@RequestBody UserModel user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    //Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getProblemById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Update User
    // @PutMapping("/{id}")
    // public ResponseEntity<UserModel> updateProblem(@PathVariable Long id, @RequestBody UserModel updated) {
    //     return userRepository.findById(id).map(user -> {
    //         user.setUsername(updated.getUsername());
    //         user.setPassword(passwordEncoder.encode(updated.getPassword()));
            
    //         user.setRole(updated.getRole());
    //         return ResponseEntity.ok(userRepository.save(user));
    //     }).orElse(ResponseEntity.notFound().build());
    // }
    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel updated){
        UserModel current=userRepository.findById(id).orElse(null);
        if(current!=null){
            current.setUsername(updated.getUsername());
            current.setPassword(passwordEncoder.encode(updated.getPassword()));
            current.setRole(updated.getRole());
            userRepository.save(current);
            return current;
        }
        return null;
    }
    //Delete an User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

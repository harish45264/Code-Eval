package com.EE.CodeEval.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.EE.CodeEval.model.UserModel;
import com.EE.CodeEval.repository.UserRepository;

@Component
 public class CustomerUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //Fetch user from database
        UserModel user= userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not Found"));

        
        return new User(user.getUsername(),user.getPassword(),Collections.singleton(new SimpleGrantedAuthority("USER")));  
        
    } 

}

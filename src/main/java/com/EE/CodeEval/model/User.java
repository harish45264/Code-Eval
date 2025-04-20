package com.EE.CodeEval.model;


import org.springframework.security.core.*;

import org.springframework.security.core.authority.*;
import java.util.*;
import java.io.*;
import java.lang.Object;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.matcher.CollectionSizeMatcher;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users") // optional
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;
    
     public List<GrantedAuthority> getAuthorities() {
        
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}  

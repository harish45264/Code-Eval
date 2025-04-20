package com.EE.CodeEval.model;

import org.assertj.core.internal.bytebuddy.matcher.CollectionSizeMatcher;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        
        return CollectionSizeMatcher.singletonList(new SimpleGrantedAuthority(role));
    }
}  

package com.EE.CodeEval.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.*;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import java.util.List;

import com.EE.CodeEval.security.JwtFilter;
import com.EE.CodeEval.service.CustomerUserDetailService;

@Configuration
@EnableWebSecurity


public class SecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authz->
        authz
        .requestMatchers(HttpMethod.POST,"/users/**").permitAll()
        // .requestMatchers(HttpMethod.GET,"/users/**").permitAll()
        .requestMatchers("/users").authenticated() 
        // .requestMatchers("/problems").permitAll()
        // .requestMatchers("/problems/**").authenticated()
        .anyRequest().permitAll() 

        )
        // .formLogin(form->form.permitAll().defaultSuccessUrl("/dashboard"))
        .csrf(csrf->csrf.disable())
        .sessionManagement(sess ->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class)
        ;

        return  http.build();

    }

    @Bean
    public UserDetailsService userDetailService(){
        // UserDetails admin =User.withUsername("bagath").password(passwordEncoder.encode("6551")).roles("ADMIN").build();


        // UserDetails user =User.withUsername("Harish").password(passwordEncoder.encode("ragini#45")).roles("USER").build();

        // return new InMemoryUserDetailsManager(user,admin);

        return new CustomerUserDetailService();
            
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider =new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public  AuthenticationManager authenticationManager(){
        return new ProviderManager(List.of(authenticationProvider()));
    }
}

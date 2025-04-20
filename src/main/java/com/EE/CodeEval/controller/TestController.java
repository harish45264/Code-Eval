package com.EE.CodeEval.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import com.EE.CodeEval.repository.*;
import com.EE.CodeEval.model.*;

@RequiredArgsConstructor
public class TestController {
    private final ProblemRepository repo;


    
    @GetMapping("/test")
    public String test() {
        repo.save(new Problem(null, "Two Sum", "Easy", "Find two numbers..."));
        return "Inserted!";
    }
}


package com.EE.CodeEval;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TestController{
        
    @GetMapping("/test")
    public String requestMethodName() {
        return "Test phase Completed";
    }
    
}


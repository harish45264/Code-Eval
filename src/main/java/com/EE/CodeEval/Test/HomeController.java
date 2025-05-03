package com.EE.CodeEval.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {

@GetMapping
public String getHomePage(){
    return "Welcome to Home Page mamae";
}
@GetMapping("/dashboard")
public String getDashBoard(){
    return "Login Successfull";
}
}

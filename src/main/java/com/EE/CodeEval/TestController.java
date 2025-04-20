package com.EE.CodeEval;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.EE.CodeEval.repository.ProblemRepository;
import com.EE.CodeEval.model.*;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final ProblemRepository repo;

    @GetMapping("/test")
    public String test() {
        repo.save(new Problem(null, "Two Sum", "Easy", "Find two numbers..."));
        return "Inserted!";
    }
}

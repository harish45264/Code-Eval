package com.EE.CodeEval.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.EE.CodeEval.model.*;
import com.EE.CodeEval.service.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/problems")
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService service;

    @GetMapping
    public List<Problem> getAll() {
        return service.getAllProblems();
    }

     @PostMapping
    public Problem create(@RequestBody Problem p) {
        return service.createProblem(p);
    }
}

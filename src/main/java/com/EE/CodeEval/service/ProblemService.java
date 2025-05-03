// package com.EE.CodeEval.service;

// import org.springframework.stereotype.Service;

// import lombok.RequiredArgsConstructor;
// import  com.EE.CodeEval.model.*;
// import  com.EE.CodeEval.repository.*;
// import  java.util.*;

// @Service
// @RequiredArgsConstructor
// public class ProblemService {
//     private final ProblemRepository repo;

//     public List<Problem> getAllProblems() {
//         return repo.findAll();
//     }

//     public Problem createProblem(Problem p) {
//         return repo.save(p);
//     }

//     // Add update and delete if needed
// }
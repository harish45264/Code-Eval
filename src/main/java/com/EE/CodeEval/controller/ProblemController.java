package com.EE.CodeEval.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.EE.CodeEval.model.*;
// import com.EE.CodeEval.service.*;
import com.EE.CodeEval.repository.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/problems")
@RequiredArgsConstructor
public class ProblemController {


    private final ProblemRepository repo;

    // 1. Get all problems
    @GetMapping
    public List<Problem> getAllProblems() {
        return repo.findAll();
    }

    // 2. Get problem by ID
    
    @GetMapping("/{id}")
    public Problem getProblems(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }
    // 3. Add a new problem
    @PostMapping
    public Problem createProblem(@RequestBody Problem problem) {
        return repo.save(problem);
    }

    // 4. Update a problem
    @PutMapping("/{id}")
    public Problem updateProblem(@PathVariable Long id, @RequestBody Problem updated) {
        Problem current=repo.findById(id).orElse(null);
        if(current!=null){
            current.setTitle(updated.getTitle());
            current.setDifficulty(updated.getDifficulty());
            current.setDescription(updated.getDescription());
            repo.save(current);
            return current;
        }
return null;
        
    }

    // 5. Delete a problem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProblem(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
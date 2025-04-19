
package com.EE.CodeEval.controller;



import com.EE.CodeEval.model.Problem;
import com.EE.CodeEval.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Problem> getProblemById(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public Problem createProblem(@RequestBody Problem problem) {
        return repo.save(problem);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Problem> updateProblem(@PathVariable Long id, @RequestBody Problem updated) {
        return repo.findById(id).map(problem -> {
            problem.setTitle(updated.getTitle());
            problem.setDifficulty(updated.getDifficulty());
            problem.setDescription(updated.getDescription());
            return ResponseEntity.ok(repo.save(problem));
        }).orElse(ResponseEntity.notFound().build());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProblem(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

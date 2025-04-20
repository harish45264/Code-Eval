package com.EE.CodeEval.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EE.CodeEval.model.Problem;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
}


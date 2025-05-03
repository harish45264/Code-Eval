// package com.EE.CodeEval.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor

// public class Submission {
//     @Id
//     @GeneratedValue
//     private Long id;

//     private String code;
//     private String language;

//     @ManyToOne
//     private User user;

//     @ManyToOne
//     private Problem problem;

//     private String result; // "Success", "Failed", etc.
// }

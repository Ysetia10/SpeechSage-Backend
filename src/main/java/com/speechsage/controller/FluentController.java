// package com.speechsage.controller;

// import org.springframework.web.bind.annotation.*;
// import java.util.*;

// @RestController
// @RequestMapping("/api/fluent")
// public class FluentController {

//     // Sample word replacements, you can replace this logic later with a more robust one
//     private static final Map<String, String> replacementMap = Map.of(
//         "pronunciation", "saying",
//         "articulate", "express",
//         "difficult", "hard",
//         "communication", "talking"
//     );

//     @PostMapping("/simplify")
//     public Map<String, String> simplifyText(@RequestBody Map<String, String> request) {
//         String inputText = request.get("text");
//         String simplifiedText = simplify(inputText);

//         return Map.of("original", inputText, "simplified", simplifiedText);
//     }

//     private String simplify(String text) {
//         for (Map.Entry<String, String> entry : replacementMap.entrySet()) {
//             text = text.replaceAll("(?i)\\b" + entry.getKey() + "\\b", entry.getValue());
//         }
//         return text;
//     }
// }

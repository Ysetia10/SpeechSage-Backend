package com.speechsage.controller;

import com.speechsage.model.AudioAnalysisResult;
import com.speechsage.service.AudioAnalysisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/audio")
@CrossOrigin(origins = "http://localhost:3000")
public class AudioAnalysisController {

    private final AudioAnalysisService service;

    public AudioAnalysisController(AudioAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> analyzeAudio(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded");
        }

        try {
            AudioAnalysisResult result = service.analyzeAndStore(file);
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to process audio");
        }
    }

//    @GetMapping("/last")
//    public ResponseEntity<AudioAnalysisResult> getLastAnalysis() {
//        Optional<AudioAnalysisResult> result = service.getLastAnalysis();
//        if (result.isPresent()) {
//            return ResponseEntity.ok(result.get());
//        } else {
//            return ResponseEntity.status(404).build();
//        }
//    }

}

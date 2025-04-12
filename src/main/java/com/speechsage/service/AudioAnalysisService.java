package com.speechsage.service;

import com.speechsage.model.AudioAnalysisResult;
import com.speechsage.repository.AudioAnalysisRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class AudioAnalysisService {

    private final AudioAnalysisRepository repository;

    public AudioAnalysisService(AudioAnalysisRepository repository) {
        this.repository = repository;
    }

    public AudioAnalysisResult analyzeAndStore(MultipartFile file) throws IOException {

        String contentType = file.getContentType();
        String originalFilename = file.getOriginalFilename();
    
        System.out.println("Uploaded file: " + originalFilename);
        System.out.println("Content type: " + contentType);

        // Simulate ML analysis
        String analysis = "Mild stuttering detected in 2 segments";
        String fileName = file.getOriginalFilename();
        LocalDateTime timestamp = LocalDateTime.now();

        // Save to DB
        AudioAnalysisResult result = new AudioAnalysisResult(fileName, analysis, timestamp);
        return repository.save(result);
    }
}

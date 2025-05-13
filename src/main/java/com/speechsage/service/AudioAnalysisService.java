package com.speechsage.service;

import com.speechsage.model.AudioAnalysisResult;
import com.speechsage.repository.AudioAnalysisRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

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
        LocalDateTime uploadedAt = LocalDateTime.now();

        AudioAnalysisResult result = new AudioAnalysisResult(originalFilename, analysis, uploadedAt);
        return repository.save(result);
    }

    public Optional<AudioAnalysisResult> getLastAnalysis() {
        return repository.findAll()
                .stream()
                .max(Comparator.comparing(AudioAnalysisResult::getUploadedAt));
    }
}

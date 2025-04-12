package com.speechsage.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AudioAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String analysisResult;

    private LocalDateTime uploadedAt;

    public AudioAnalysisResult() {}

    public AudioAnalysisResult(String fileName, String analysisResult, LocalDateTime uploadedAt) {
        this.fileName = fileName;
        this.analysisResult = analysisResult;
        this.uploadedAt = uploadedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getAnalysisResult() { return analysisResult; }

    public void setAnalysisResult(String analysisResult) { this.analysisResult = analysisResult; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }

    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }
}

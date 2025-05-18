package com.speechsage.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audio_analysis_result")
public class AudioAnalysisResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "analysis_result", columnDefinition = "TEXT")
    private String transcription;

    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;

    // Constructors
    public AudioAnalysisResult() {}

    public AudioAnalysisResult(String fileName, String transcription, LocalDateTime uploadedAt) {
        this.fileName = fileName;
        this.transcription = transcription;
        this.uploadedAt = uploadedAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}

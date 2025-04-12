package com.speechsage.repository;

import com.speechsage.model.AudioAnalysisResult;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioAnalysisRepository extends JpaRepository<AudioAnalysisResult, Long> {
}

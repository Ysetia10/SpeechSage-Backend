package com.speechsage.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.speechsage.model.AudioAnalysisResult;
import com.speechsage.repository.AudioAnalysisRepository;
import com.speechsage.utils.MultipartInputStreamFileResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;


@Service
public class AudioAnalysisService {

    private final AudioAnalysisRepository repository;
    private final RestTemplate restTemplate;

    public AudioAnalysisService(AudioAnalysisRepository repository) {
        this.repository = repository;
        this.restTemplate = new RestTemplate();
    }

    public AudioAnalysisResult analyzeAndStore(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("audio", new MultipartInputStreamFileResource(file.getInputStream(), originalFilename));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String flaskUrl = "http://127.0.0.1:4000/predict";

        ResponseEntity<String> response = restTemplate.postForEntity(flaskUrl, requestEntity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String jsonResponse = response.getBody();

            ObjectMapper mapper = new ObjectMapper();
            Object json = mapper.readValue(jsonResponse, Object.class); // Parse JSON
            String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json); // Pretty print JSON

            AudioAnalysisResult result = new AudioAnalysisResult(originalFilename, prettyJson, LocalDateTime.now());
            return repository.save(result);
        } else {
            throw new IOException("Failed to analyze audio via Python service");
        }
    }
}

package com.speechsage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.speechsage.model")
public class SpeechSageApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpeechSageApplication.class, args);
    }
}

package br.com.toloni.springbatchapp;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchAppApplication.class, args);
    }
}

package br.com.toloni.springbatchapp;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job printHelloWorldJob() {
        return jobBuilderFactory.get("printHelloWorldJob").start(printHelloWorldStep()).build();
    }

    private Step printHelloWorldStep() {
        return stepBuilderFactory.get("printHelloWorldStep").tasklet(this::printHelloWorldTask).build();
    }

    private RepeatStatus printHelloWorldTask(StepContribution stepContribution, ChunkContext chunkContext) {
        System.out.println("Hello World Spring Batch!");
        return RepeatStatus.FINISHED;
    }
}
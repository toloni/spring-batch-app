package br.com.toloni.springbatchapp.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RatingClientJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job ratingClientJob(Step ratingClientStep) {
        return jobBuilderFactory
                .get("ratingClientJob")
                .start(ratingClientStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}

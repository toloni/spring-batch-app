package br.com.toloni.springbatchapp.batch.job;

import br.com.toloni.springbatchapp.usecase.RatingClientUseCase;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class RatingClientJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job job(
            Step step1,
            Step step2
    ) {
        return jobBuilderFactory
                .get("ratingClientJob")
                .start(step1)
                .next(step2)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}

package br.com.toloni.springbatchapp.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RatingClientJob {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job job(Step step) {
        return jobBuilderFactory
                .get("ratingClientJob")
                .start(step)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}

package br.com.toloni.springbatchapp.batch.step;

import br.com.toloni.springbatchapp.persistence.entity.Rating;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ExtractTableToFileStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step2(
            JdbcPagingItemReader<Rating> ratingJdbcPagingItemReader,
            FlatFileItemWriter<Rating> ratingFlatFileItemWriter
    ) {
        return stepBuilderFactory
                .get("ratingClientStep")
                .<Rating, Rating>chunk(1)
                .reader(ratingJdbcPagingItemReader)
                .writer(ratingFlatFileItemWriter)
                .build();
    }

}

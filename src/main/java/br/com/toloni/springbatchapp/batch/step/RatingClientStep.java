package br.com.toloni.springbatchapp.batch.step;

import br.com.toloni.springbatchapp.persistence.entity.Client;
import br.com.toloni.springbatchapp.persistence.entity.Rating;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RatingClientStep {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step(
            JdbcPagingItemReader<Client> clientJdbcPagingItemReader,
            ItemProcessor<Client, Rating> clientRatingItemProcessor,
            JdbcBatchItemWriter<Rating> ratingItemWriter
    ) {
        return stepBuilderFactory
                .get("ratingClientStep")
                .<Client, Rating>chunk(1)
                .reader(clientJdbcPagingItemReader)
                .processor(clientRatingItemProcessor)
                .writer(ratingItemWriter)
                .build();
    }
}

package br.com.toloni.springbatchapp.batch.step;

import br.com.toloni.springbatchapp.batch.processor.RatingClientProcessor;
import br.com.toloni.springbatchapp.batch.writer.RatingWriter;
import br.com.toloni.springbatchapp.persistence.entity.Client;
import br.com.toloni.springbatchapp.persistence.entity.Rating;
import br.com.toloni.springbatchapp.usecase.RatingClientUseCase;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class RatingClientStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private RatingClientUseCase ratingClientUseCase;

    @Autowired
    @Qualifier("appADataSource")
    private DataSource dataSource;

    @Bean
    public Step step1(
            JdbcPagingItemReader<Client> clientJdbcPagingItemReader
    ) {
        return stepBuilderFactory
                .get("ratingClientStep")
                .<Client, Rating>chunk(1)
                .reader(clientJdbcPagingItemReader)
                .processor(new RatingClientProcessor(ratingClientUseCase))
                .writer(new RatingWriter(dataSource))
                .build();
    }
}

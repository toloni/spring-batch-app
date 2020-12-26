package br.com.toloni.springbatchapp.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OddsOrEvensStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step oddsOrEvensStep(
            IteratorItemReader<Integer> countUntilTenReader,
            FunctionItemProcessor<Integer, String> oddsOrEvensProcessor,
            ItemWriter<String> resultWriter
    ) {
        return stepBuilderFactory.get("oddsOrEvensStep")
                .<Integer, String>chunk(1)
                .reader(countUntilTenReader)
                .processor(oddsOrEvensProcessor)
                .writer(resultWriter)
                .build();
    }

}

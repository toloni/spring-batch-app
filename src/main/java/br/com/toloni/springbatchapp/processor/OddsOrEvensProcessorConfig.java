package br.com.toloni.springbatchapp.processor;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OddsOrEvensProcessorConfig {

    @Bean
    @StepScope
    public FunctionItemProcessor<Integer, String> oddsOrEvensProcessor() {
        return new FunctionItemProcessor<Integer, String>(
                x -> x % 2 == 0 ? "É PAR..: " + x : "É IMPAR: " + x
        );
    }

}

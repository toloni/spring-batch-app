package br.com.toloni.springbatchapp;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Configuration
public class HelloWorldBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job oddsOrEvensJob() {
        return jobBuilderFactory.get("oddsOrEvensJob").start(oddsOrEvensStep()).build();
    }

    private Step oddsOrEvensStep() {
        return stepBuilderFactory.get("oddsOrEvensStep")
                .<Integer, String>chunk(1)
                .reader(countUntilTenReader())
                .processor(oddsOrEvensProcessor())
                .writer(resultWriter())
                .build();
    }

    private ItemWriter<String> resultWriter() {
        return x -> x.forEach(System.out::println);
    }

    private FunctionItemProcessor<Integer, String> oddsOrEvensProcessor() {
        return new FunctionItemProcessor<Integer, String>
                (x -> x % 2 == 0 ? "É PAR..: " + x : "É IMPAR: " + x);
    }

    private IteratorItemReader<Integer> countUntilTenReader() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<Integer>(list);
    }


}
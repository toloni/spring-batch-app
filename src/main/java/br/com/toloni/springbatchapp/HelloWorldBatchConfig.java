package br.com.toloni.springbatchapp;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

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
                .<Numbers, String>chunk(1)
                .reader(fileReader())
                .processor(oddsOrEvensProcessor())
                .writer(resultWriter())
                .build();
    }

    private ItemWriter<String> resultWriter() {
        return x -> x.forEach(System.out::println);
    }

    private FunctionItemProcessor<Numbers, String> oddsOrEvensProcessor() {
        return new FunctionItemProcessor<Numbers, String>
                (x -> x.number % 2 == 0 ? "É PAR..: " + x : "É IMPAR: " + x);
    }

    private FlatFileItemReader<Numbers> fileReader() {

        //Create reader instance
        FlatFileItemReader<Numbers> reader = new FlatFileItemReader<Numbers>();

        //Set input file location
        reader.setResource(new FileSystemResource("input/inputData.txt"));

        //Set number of lines to skips. Use it if file has header rows.
        //reader.setLinesToSkip(1);

        //Configure how each line will be parsed and mapped to different values
        reader.setLineMapper(new DefaultLineMapper() {
            {
                //1 column in each row
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"number"});
                    }
                });
                //Set values in Numbers class
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Numbers>() {
                    {
                        setTargetType(Numbers.class);
                    }
                });
            }
        });

        return reader;
    }

}
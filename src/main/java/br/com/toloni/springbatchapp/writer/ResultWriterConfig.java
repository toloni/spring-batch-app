package br.com.toloni.springbatchapp.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResultWriterConfig {

    @Bean
    public ItemWriter<String> resultWriter() {
        return x -> x.forEach(System.out::println);
    }
}

package br.com.toloni.springbatchapp.writer;

import br.com.toloni.springbatchapp.domain.Rating;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RatingWriterConfig {

    @Bean
    public ItemWriter<Rating> ratingItemWriter() {
        return x -> x.forEach(y -> System.out.println(y.toString()));
    }
}

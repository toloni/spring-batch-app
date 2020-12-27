package br.com.toloni.springbatchapp.processor;

import br.com.toloni.springbatchapp.domain.Client;
import br.com.toloni.springbatchapp.domain.Rating;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.UUID;

@Configuration
public class RatingClientProcessorConfig {

    @Bean
    public ItemProcessor<Client, Rating> clientRatingItemProcessor() {

        return this::process;
    }

    public Rating process(Client client) throws Exception {

        return new Rating(
                UUID.randomUUID(),
                LocalDate.now(),
                client.getIdClient(),
                1
        );
    }
}

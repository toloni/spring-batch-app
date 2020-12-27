package br.com.toloni.springbatchapp.processor;

import br.com.toloni.springbatchapp.domain.Client;
import br.com.toloni.springbatchapp.domain.Rating;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class RatingClientProcessor {

    @Bean
    public ItemProcessor<Client, Rating> clientRatingItemProcessor() {

        return this::process;
    }

    public Rating process(Client client) throws Exception {

        return new Rating(
                UUID.randomUUID(),
                LocalDateTime.now(),
                client.getIdClient(),
                1
        );
    }
}

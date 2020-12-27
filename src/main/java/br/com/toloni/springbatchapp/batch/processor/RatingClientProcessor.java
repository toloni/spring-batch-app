package br.com.toloni.springbatchapp.batch.processor;

import br.com.toloni.springbatchapp.persistence.entity.Client;
import br.com.toloni.springbatchapp.persistence.entity.Rating;
import br.com.toloni.springbatchapp.usecase.RatingClientUseCase;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RatingClientProcessor {

    @Autowired
    private RatingClientUseCase ratingClientUseCase;

    @Bean
    public ItemProcessor<Client, Rating> clientRatingItemProcessor() {

        return this::process;
    }

    public Rating process(Client client) throws Exception {

        return ratingClientUseCase.newRaging(client);
    }
}

package br.com.toloni.springbatchapp.batch.processor;

import br.com.toloni.springbatchapp.persistence.entity.Client;
import br.com.toloni.springbatchapp.persistence.entity.Rating;
import br.com.toloni.springbatchapp.usecase.RatingClientUseCase;
import org.springframework.batch.item.ItemProcessor;

public class RatingClientProcessor implements ItemProcessor<Client, Rating> {

    private RatingClientUseCase ratingClientUseCase;

    public RatingClientProcessor(RatingClientUseCase ratingClientUseCase) {
        this.ratingClientUseCase = ratingClientUseCase;
    }

    @Override
    public Rating process(Client client) throws Exception {

        return ratingClientUseCase.newRaging(client);
    }
}

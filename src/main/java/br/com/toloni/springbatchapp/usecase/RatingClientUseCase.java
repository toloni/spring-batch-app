package br.com.toloni.springbatchapp.usecase;

import br.com.toloni.springbatchapp.persistence.entity.Client;
import br.com.toloni.springbatchapp.persistence.entity.Rating;
import br.com.toloni.springbatchapp.usecase.dto.ApiRatingRequestDto;
import br.com.toloni.springbatchapp.usecase.dto.ApiRatingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

@Component
public class RatingClientUseCase {

    private static final String url = "http://localhost:8080/api/rating";

    @Autowired
    private RestTemplate restTemplate;

    public Rating newRaging(Client client) throws URISyntaxException {

        ResponseEntity<ApiRatingResponseDto> response
                = restTemplate.postForEntity(
                new URI(url),
                dataRequest(client),
                ApiRatingResponseDto.class);
        return dataResponse(client.getIdClient(), response.getBody());
    }

    private Rating dataResponse(long idClient, ApiRatingResponseDto body) {

        var data = new Rating();
        data.setIdRating(body.getId_rate());
        data.setDateRating(LocalDateTime.now());
        data.setIdClient(idClient);
        data.setNumberStarsRating(body.getNumber_stars_rate());

        return data;
    }

    private ApiRatingRequestDto dataRequest(Client client) {

        var data = new ApiRatingRequestDto();
        data.setId_client(client.getIdClient());
        data.setFirst_name_client(client.getFirstNameClient());
        data.setLast_name_client(client.getLastNameClient());
        data.setEmail_client(client.getEmailClient());

        System.out.println(data.toString());
        return data;
    }
}

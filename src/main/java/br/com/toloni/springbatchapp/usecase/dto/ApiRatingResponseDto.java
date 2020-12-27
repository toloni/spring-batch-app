package br.com.toloni.springbatchapp.usecase.dto;

import java.util.UUID;

public class ApiRatingResponseDto {

    private UUID id_rate;

    private Integer number_stars_rate;

    public ApiRatingResponseDto() {
    }

    public ApiRatingResponseDto(UUID id_rate, Integer number_stars_rate) {
        this.id_rate = id_rate;
        this.number_stars_rate = number_stars_rate;
    }

    public UUID getId_rate() {
        return id_rate;
    }

    public void setId_rate(UUID id_rate) {
        this.id_rate = id_rate;
    }

    public Integer getNumber_stars_rate() {
        return number_stars_rate;
    }

    public void setNumber_stars_rate(Integer number_stars_rate) {
        this.number_stars_rate = number_stars_rate;
    }
}

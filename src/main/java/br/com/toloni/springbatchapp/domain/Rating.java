package br.com.toloni.springbatchapp.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Rating {

    private UUID idRating;
    private LocalDate dateRating;
    private Long idClient;
    private Integer numberStarsRating;

    public Rating() {
    }

    public Rating(UUID idRating, LocalDate dateRating, Long idClient, Integer numberStarsRating) {
        this.idRating = idRating;
        this.dateRating = dateRating;
        this.idClient = idClient;
        this.numberStarsRating = numberStarsRating;
    }

    public UUID getIdRating() {
        return idRating;
    }

    public void setIdRating(UUID idRating) {
        this.idRating = idRating;
    }

    public LocalDate getDateRating() {
        return dateRating;
    }

    public void setDateRating(LocalDate dateRating) {
        this.dateRating = dateRating;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Integer getNumberStarsRating() {
        return numberStarsRating;
    }

    public void setNumberStarsRating(Integer numberStarsRating) {
        this.numberStarsRating = numberStarsRating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "idRating=" + idRating +
                ", dateRating=" + dateRating +
                ", idClient=" + idClient +
                ", numberStarsRating=" + numberStarsRating +
                '}';
    }
}

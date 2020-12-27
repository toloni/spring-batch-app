package br.com.toloni.springbatchapp.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Rating {

    private UUID idRating;
    private LocalDateTime dateRating;
    private Long idClient;
    private Integer numberStarsRating;

    public Rating() {
    }

    public Rating(UUID idRating, LocalDateTime dateRating, Long idClient, Integer numberStarsRating) {
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

    public LocalDateTime getDateRating() {
        return dateRating;
    }

    public void setDateRating(LocalDateTime dateRating) {
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

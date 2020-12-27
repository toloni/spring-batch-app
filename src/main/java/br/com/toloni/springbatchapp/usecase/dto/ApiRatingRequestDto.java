package br.com.toloni.springbatchapp.usecase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiRatingRequestDto {

    @JsonProperty("id_client")
    private Long id_client;

    @JsonProperty("first_name_client")
    private String first_name_client;

    @JsonProperty("last_name_client")
    private String last_name_client;

    @JsonProperty("email_client")
    private String email_client;

    public ApiRatingRequestDto() {
    }

    public ApiRatingRequestDto(Long id_client, String first_name_client, String last_name_client, String email_client) {
        this.id_client = id_client;
        this.first_name_client = first_name_client;
        this.last_name_client = last_name_client;
        this.email_client = email_client;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public String getFirst_name_client() {
        return first_name_client;
    }

    public void setFirst_name_client(String first_name_client) {
        this.first_name_client = first_name_client;
    }

    public String getLast_name_client() {
        return last_name_client;
    }

    public void setLast_name_client(String last_name_client) {
        this.last_name_client = last_name_client;
    }

    public String getEmail_client() {
        return email_client;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }

    @Override
    public String toString() {
        return "ApiRatingRequestDto{" +
                "id_client=" + id_client +
                ", first_name_client='" + first_name_client + '\'' +
                ", last_name_client='" + last_name_client + '\'' +
                ", email_client='" + email_client + '\'' +
                '}';
    }
}

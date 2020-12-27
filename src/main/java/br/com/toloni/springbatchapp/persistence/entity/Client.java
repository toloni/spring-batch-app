package br.com.toloni.springbatchapp.persistence.entity;

public class Client {

    private Long idClient;
    private String firstNameClient;
    private String lastNameClient;
    private String emailClient;

    public Client() {
    }

    public Client(Long idClient, String firstNameClient, String lastNameClient, String emailClient) {
        this.idClient = idClient;
        this.firstNameClient = firstNameClient;
        this.lastNameClient = lastNameClient;
        this.emailClient = emailClient;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getFirstNameClient() {
        return firstNameClient;
    }

    public void setFirstNameClient(String firstNameClient) {
        this.firstNameClient = firstNameClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }
}

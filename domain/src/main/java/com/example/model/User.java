package com.example.model;

/**
 * A model of user.
 */
public class User {

    private String idUser;
    private String pseudoUser;
    private String passwordUser;

    @SuppressWarnings("unused")
    public User(String idUser, String pseudoUser, String passwordUser) {
        this.idUser = idUser;
        this.pseudoUser = pseudoUser;
        this.passwordUser = passwordUser;
    }

    public User() {}

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPseudoUser() {
        return pseudoUser;
    }

    public void setPseudoUser(String pseudoUser) {
        this.pseudoUser = pseudoUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
}

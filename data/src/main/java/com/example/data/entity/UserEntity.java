package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * "User" entity mapped on the database table "User".
 */
public class UserEntity {

    @SerializedName("idUser")
    private int idUser;

    @SerializedName("pseudoUser")
    private String pseudoUser;

    @SerializedName("passwordUser")
    private String passwordUser;

    public int getIdUser() { return idUser; }

    @SuppressWarnings("unused")
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPseudoUser() {
        return pseudoUser;
    }

    @SuppressWarnings("unused")
    public void setPseudoUser(String pseudoUser) {
        this.pseudoUser = pseudoUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    @SuppressWarnings("unused")
    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
}

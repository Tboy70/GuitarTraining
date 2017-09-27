package com.example.data.entity.remote;

import com.google.gson.annotations.SerializedName;

/**
 * User remote entity mapping the JSON.
 */
public class UserRemoteEntity {

    @SerializedName("idUser")
    private String idUser;

    @SerializedName("pseudoUser")
    private String pseudoUser;

    @SerializedName("passwordUser")
    private String passwordUser;

    public String getIdUser() {
        return idUser;
    }

    @SuppressWarnings("unused")
    public void setIdUser(String idUser) {
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

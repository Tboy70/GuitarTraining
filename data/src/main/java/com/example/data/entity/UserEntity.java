package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Thomas on 13/03/2017.
 */

public class UserEntity {

    @SerializedName("id_user")
    private int idUser;

    @SerializedName("first_name_user")
    private String firstNameUser;

    @SerializedName("last_name_user")
    private String lastNameUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstNameUser() {
        return firstNameUser;
    }

    public void setFirstNameUser(String firstNameUser) {
        this.firstNameUser = firstNameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }
}

package com.example.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Text entity mapping the database.
 */
public class TextEntity {

    @SerializedName("idText")
    private int idText;

    @SerializedName("nameText")
    private String nameText;

    @SerializedName("contentText")
    private String contentText;

    public int getIdText() {
        return idText;
    }

    public void setIdText(int idText) {
        this.idText = idText;
    }

    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }
}

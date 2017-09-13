package com.example.data.entity.remote;

import com.google.gson.annotations.SerializedName;

/**
 * Text remote entity mapping the JSON.
 */
public class TextRemoteEntity {

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

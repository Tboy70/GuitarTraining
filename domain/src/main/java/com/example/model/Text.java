package com.example.model;

/**
 * Text model.
 */
public class Text {

    private int idText;
    private String nameText;
    private String contentText;

    @SuppressWarnings("unused")
    public Text(int idText, String nameText, String contentText) {
        this.idText = idText;
        this.nameText = nameText;
        this.contentText = contentText;
    }

    public Text() {
    }

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

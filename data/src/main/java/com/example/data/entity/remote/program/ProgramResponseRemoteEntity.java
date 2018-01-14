package com.example.data.entity.remote.program;

import com.google.gson.annotations.SerializedName;

public class ProgramResponseRemoteEntity {

    @SerializedName("createdId")
    private String createdId;

    public String getCreatedId() {
        return createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }
}

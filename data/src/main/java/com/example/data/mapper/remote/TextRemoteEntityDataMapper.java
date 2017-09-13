package com.example.data.mapper.remote;

import com.example.data.entity.TextEntity;
import com.example.data.entity.remote.TextRemoteEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper to pass from text remote entity to text entity and vice versa.
 */
@Singleton
public class TextRemoteEntityDataMapper {

    @SuppressWarnings("WeakerAccess")
    @Inject
    public TextRemoteEntityDataMapper() {
    }

    @SuppressWarnings("unused")
    public List<TextEntity> transformRemoteToEntityList(List<TextRemoteEntity> textRemoteEntities) {
        List<TextEntity> textEntities = new ArrayList<>();
        for (TextRemoteEntity textRemoteEntity : textRemoteEntities) {
            textEntities.add(transformRemoteToEntity(textRemoteEntity));
        }
        return textEntities;
    }

    public TextEntity transformRemoteToEntity(TextRemoteEntity textRemoteEntity) {
        TextEntity textEntity = new TextEntity();
        textEntity.setIdText(textRemoteEntity.getIdText());
        textEntity.setNameText(textRemoteEntity.getNameText());
        textEntity.setContentText(textRemoteEntity.getContentText());
        return textEntity;
    }

    @SuppressWarnings("unused")
    public List<TextRemoteEntity> transformEntityToRemoteList(List<TextEntity> textEntities) {
        List<TextRemoteEntity> textRemoteEntities = new ArrayList<>();
        for (TextEntity textEntity : textEntities) {
            textRemoteEntities.add(transformEntityToRemote(textEntity));
        }
        return textRemoteEntities;
    }

    private TextRemoteEntity transformEntityToRemote(TextEntity textEntity) {
        TextRemoteEntity textRemoteEntity = new TextRemoteEntity();
        textRemoteEntity.setIdText(textEntity.getIdText());
        textRemoteEntity.setNameText(textEntity.getNameText());
        textRemoteEntity.setContentText(textEntity.getContentText());
        return textRemoteEntity;
    }
}

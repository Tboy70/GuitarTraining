package com.example.data.mapper;

import com.example.data.entity.TextEntity;
import com.example.model.Text;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper to pass from text model to text entity and text entity to text model.
 */
@Singleton
public class TextMapper {

    @Inject
    @SuppressWarnings("WeakerAccess")
    public TextMapper() {}

    /**
     * Transform a text entity to a text model.
     * @param textEntity The text entity to be transformed;
     * @return A text model.
     */
    public Text transformToModel(TextEntity textEntity) {
        Text textModel = new Text();

        textModel.setIdText(textEntity.getIdText());
        textModel.setNameText(textEntity.getNameText());
        textModel.setContentText(textEntity.getContentText());

        return textModel;
    }

    /**
     * Transform a text model to a text entity.
     * @param textModel The text model to be transformed.
     * @return A text entity.
     */
    @SuppressWarnings("unused")
    public TextEntity transformToEntity(Text textModel) {
        TextEntity textEntity = new TextEntity();

        textEntity.setIdText(textModel.getIdText());
        textEntity.setNameText(textModel.getNameText());
        textEntity.setContentText(textModel.getContentText());

        return textEntity;
    }
}

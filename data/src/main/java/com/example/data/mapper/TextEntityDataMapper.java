package com.example.data.mapper;

import com.example.data.entity.TextEntity;
import com.example.model.Text;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper to pass from text model to text entity and text entity to text model.
 */
@Singleton
public class TextEntityDataMapper {

    @Inject
    @SuppressWarnings("WeakerAccess")
    public TextEntityDataMapper() {
    }

    @SuppressWarnings("unused")
    public List<Text> transformEntityToModelList(List<TextEntity> textEntities) {
        List<Text> textList = new ArrayList<>();
        for (TextEntity textEntity : textEntities) {
            textList.add(transformEntityToModel(textEntity));
        }
        return textList;
    }

    public Text transformEntityToModel(TextEntity textEntity) {
        Text text = new Text();
        text.setIdText(textEntity.getIdText());
        text.setNameText(textEntity.getNameText());
        text.setContentText(textEntity.getContentText());

        return text;
    }

    @SuppressWarnings("unused")
    public List<TextEntity> transformModelToEntityList(List<Text> textList) {
        List<TextEntity> textEntityList = new ArrayList<>();
        for (Text text : textList) {
            textEntityList.add(transformModelToEntity(text));
        }
        return textEntityList;
    }

    private TextEntity transformModelToEntity(Text text) {
        TextEntity textEntity = new TextEntity();
        textEntity.setIdText(text.getIdText());
        textEntity.setNameText(text.getNameText());
        textEntity.setContentText(text.getContentText());

        return textEntity;
    }
}

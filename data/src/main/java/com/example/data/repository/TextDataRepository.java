package com.example.data.repository;

import com.example.data.entity.TextEntity;
import com.example.data.mapper.TextEntityDataMapper;
import com.example.data.repository.client.APIClient;
import com.example.model.Text;
import com.example.repository.TextRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

public class TextDataRepository implements TextRepository {

    private final TextEntityDataMapper textEntityDataMapper;
    private APIClient apiClient;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public TextDataRepository(TextEntityDataMapper textEntityDataMapper, APIClient apiClient) {
        this.textEntityDataMapper = textEntityDataMapper;
        this.apiClient = apiClient;
    }

    @Override
    public Observable<Text> getTextIntroProgram(int idProgram) {
        Observable<TextEntity> resultFromAPI;
        switch (idProgram) {
            case 1:
                resultFromAPI = apiClient.getTextIntroProgram(2);
                break;
            case 2:
                resultFromAPI = apiClient.getTextIntroProgram(3);
                break;
            default:
                resultFromAPI = apiClient.getTextIntroProgram(4);
                break;
        }

        return resultFromAPI.map(new Func1<TextEntity, Text>() {
            @Override
            public Text call(TextEntity textEntity) {
                return textEntityDataMapper.transformEntityToModel(textEntity);
            }
        });
    }
}

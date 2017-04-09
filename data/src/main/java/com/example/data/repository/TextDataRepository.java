package com.example.data.repository;

import com.example.data.entity.TextEntity;
import com.example.data.mapper.TextMapper;
import com.example.data.repository.client.APIClient;
import com.example.model.Text;
import com.example.repository.TextRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Thomas on 02/04/2017.
 */

public class TextDataRepository implements TextRepository {

    private final TextMapper textMapper;
    private APIClient apiClient;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public TextDataRepository(TextMapper textMapper, APIClient apiClient) {
        this.textMapper = textMapper;
        this.apiClient = apiClient;
    }

    /**
     * Get the information about the application.
     * @return An observable of Text.
     */
    @Override
    public Observable<Text> getApplicationAboutInformation() {
        return apiClient.getApplicationAboutInformationFromAPI().flatMap(new Func1<TextEntity, Observable<Text>>() {
            @Override
            public Observable<Text> call(TextEntity textEntity) {
                Text text = textMapper.transformToModel(textEntity);
                return Observable.just(text);
            }
        });
    }
}

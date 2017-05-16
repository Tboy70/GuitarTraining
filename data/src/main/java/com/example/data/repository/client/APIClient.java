package com.example.data.repository.client;

import com.example.data.entity.ProgramEntity;
import com.example.data.entity.TextEntity;
import com.example.data.entity.UserEntity;
import com.example.data.module.APIModule;
import com.example.data.module.APIModuleRetrofitImpl;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Client using the APIModule.
 */
public class APIClient {

    private final APIModule apiModule;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public APIClient(APIModuleRetrofitImpl apiModule) {
        this.apiModule = apiModule;
    }

    /**
     * To get all users of the application from the API.
     *
     * @return Observable -> List of UserEntity.
     */
    public Observable<List<UserEntity>> getAllUsersFromAPI() {
        return apiModule.getAllUsers();
    }

    /**
     * To get the information about the application.
     *
     * @return An observable of TextEntity.
     */
    public Observable<TextEntity> getApplicationAboutInformationFromAPI() {
        return apiModule.getInformationsTextAboutApplication();
    }

    public Observable<ProgramEntity> getProgramFromId(int idProgram) {
        return apiModule.getProgramById(idProgram);
    }
}

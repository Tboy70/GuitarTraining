package com.example.data.repository.client;

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
     * @return Observable -> List of UserEntity.
     */
    public Observable<List<UserEntity>> getAllUsersFromAPI() {
        return apiModule.getAllUsers();
    }
}

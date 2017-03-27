package com.example.data.module;

import com.example.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * Interface implements by APIModuleRetrofitImpl class.
 * Contains declarations of API methods.
 */
public interface APIModule {

    /**
     * Get all the users of the application.
     * @return Observable -> List of UserEntity from the database.
     */
    Observable<List<UserEntity>> getAllUsers();
}

package com.example.data.module;

import com.example.data.entity.TextEntity;
import com.example.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * Interface implements by APIModuleRetrofitImpl class.
 * Contains declarations of API methods.
 */
public interface APIModule {

    Observable<List<UserEntity>> getAllUsers();
    Observable<TextEntity> getApplicationAboutInformation();
}

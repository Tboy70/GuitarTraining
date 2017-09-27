package com.example.data.repository;

import com.example.data.entity.UserEntity;
import com.example.data.mapper.UserEntityDataMapper;
import com.example.data.repository.client.APIClient;
import com.example.data.repository.client.ContentClient;
import com.example.model.User;
import com.example.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Repository concerning the user of the application.
 */
@Singleton
public class UserDataRepository implements UserRepository {

    private UserEntityDataMapper userEntityDataMapper;
    private APIClient apiClient;
    private ContentClient contentClient;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public UserDataRepository(UserEntityDataMapper userEntityDataMapper, APIClient apiClient, ContentClient contentClient) {
        this.userEntityDataMapper = userEntityDataMapper;
        this.apiClient = apiClient;
        this.contentClient = contentClient;
    }

    @Override
    public Observable<Boolean> setIdUserInSharedPrefs(String idUser) {
        return contentClient.setIdUserInSharedPrefs(idUser);
    }

    @Override
    public Observable<User> connectUser(User user) {
        return apiClient.connectUser(userEntityDataMapper.transformModelToEntity(user)).map(new Func1<UserEntity, User>() {
            @Override
            public User call(UserEntity userEntity) {
                return userEntityDataMapper.transformEntityToModel(userEntity);
            }
        });
    }
}

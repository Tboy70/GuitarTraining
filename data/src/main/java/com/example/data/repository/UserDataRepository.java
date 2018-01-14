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
import rx.functions.Func0;
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
    public Observable<Boolean> setIdUserInSharedPrefs(final String idUser) {
        return Observable.defer(new Func0<Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call() {
                try {
                    return contentClient.setIdUserInSharedPrefs(idUser);
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        });
    }

    @Override
    public Observable<User> connectUser(final User user) {
        return Observable.defer(new Func0<Observable<User>>() {
            @Override
            public Observable<User> call() {
                try {
                    return apiClient.connectUser(userEntityDataMapper.transformModelToEntity(user)).map(new Func1<UserEntity, User>() {
                        @Override
                        public User call(UserEntity userEntity) {
                            return userEntityDataMapper.transformEntityToModel(userEntity);
                        }
                    });
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        });
    }

    @Override
    public Observable<String> getIdInSharedPrefs() {
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                try {
                    return contentClient.getIdInSharedPrefs();
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        });
    }
}

package com.example.data.repository;

import com.example.data.entity.UserEntity;
import com.example.data.mapper.UserMapper;
import com.example.data.repository.client.APIClient;
import com.example.model.User;
import com.example.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Repository concerning the user of the application.
 */
public class UserDataRepository implements UserRepository {

    private final UserMapper userMapper;
    private APIClient apiClient;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public UserDataRepository(UserMapper userMapper, APIClient apiClient) {
        this.userMapper = userMapper;
        this.apiClient = apiClient;
    }

    /**
     * Get all the users of the application.
     * @return Observable -> List of User.
     */
    @Override
    public Observable<List<User>> getAllUsers() {
        final List<User> usersList = new ArrayList<>();
        return apiClient.getAllUsersFromAPI().flatMap(new Func1<List<UserEntity>, Observable<List<User>>>() {
            @Override
            public Observable<List<User>> call(List<UserEntity> userEntities) {
                for (int i = 0; i < userEntities.size(); i++) {
                    User user = userMapper.transformToModel(userEntities.get(i));
                    usersList.add(user);
                }
                return Observable.just(usersList);
            }
        });
    }
}

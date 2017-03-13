package com.example.data.mapper;

import com.example.data.entity.UserEntity;
import com.example.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Thomas on 13/03/2017.
 */

@Singleton
public class UserMapper {

    @Inject
    public UserMapper() {}

    public User transform(UserEntity userEntity) {
        User user = new User();
        user.setIdUser(userEntity.getIdUser());
        user.setFirstNameUser(userEntity.getFirstNameUser());
        user.setLastNameUser(userEntity.getLastNameUser());

        return user;
    }
}

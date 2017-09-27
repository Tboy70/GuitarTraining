package com.example.data.mapper;

import com.example.data.entity.UserEntity;
import com.example.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper to pass a user from entity to model or model to entity.
 */
@Singleton
public class UserEntityDataMapper {

    @Inject
    @SuppressWarnings("WeakerAccess")
    public UserEntityDataMapper() {
    }

    @SuppressWarnings("unused")
    public List<User> transformEntityToModelList(List<UserEntity> userEntities) {
        List<User> userList = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            userList.add(transformEntityToModel(userEntity));
        }
        return userList;
    }

    public User transformEntityToModel(UserEntity userEntity) {
        User user = new User();
        user.setIdUser(userEntity.getIdUser());
        user.setPseudoUser(userEntity.getPseudoUser());
        user.setPasswordUser(userEntity.getPasswordUser());

        return user;
    }

    @SuppressWarnings("unused")
    public List<UserEntity> transformModelToEntityList(List<User> users) {
        List<UserEntity> userEntities = new ArrayList<>();
        for (User user : users) {
            userEntities.add(transformModelToEntity(user));
        }
        return userEntities;
    }

    public UserEntity transformModelToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setIdUser(user.getIdUser());
        userEntity.setPseudoUser(user.getPseudoUser());
        userEntity.setPasswordUser(user.getPasswordUser());

        return userEntity;
    }
}

package com.example.data.mapper;

import com.example.data.entity.UserEntity;
import com.example.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper to pass a user from entity to model or model to entity.
 */
@Singleton
public class UserMapper {

    @Inject
    @SuppressWarnings("WeakerAccess")
    public UserMapper() {
    }

    /**
     * To transform a "User" entity to "User" model.
     *
     * @param userEntity A user entity.
     * @return A user model.
     */
    public User transformToModel(UserEntity userEntity) {
        User userModel = new User();

        userModel.setIdUser(userEntity.getIdUser());
        userModel.setPseudoUser(userEntity.getPseudoUser());
        userModel.setPasswordUser(userEntity.getPasswordUser());

        return userModel;
    }

    /**
     * To transform a "User" model to "User" entity.
     *
     * @param userModel A user model
     * @return A user entity.
     */
    @SuppressWarnings("unused")
    public UserEntity transformToEntity(User userModel) {
        UserEntity userEntity = new UserEntity();

        userEntity.setIdUser(userModel.getIdUser());
        userEntity.setPseudoUser(userModel.getPseudoUser());
        userEntity.setPasswordUser(userModel.getPasswordUser());

        return userEntity;
    }
}

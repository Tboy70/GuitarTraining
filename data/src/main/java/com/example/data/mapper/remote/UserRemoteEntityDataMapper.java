package com.example.data.mapper.remote;

import com.example.data.entity.UserEntity;
import com.example.data.entity.remote.UserRemoteEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper to pass from user remote entity to user entity and vice versa.
 */
@Singleton
public class UserRemoteEntityDataMapper {

    @SuppressWarnings("WeakerAccess")
    @Inject
    public UserRemoteEntityDataMapper() {
    }

    @SuppressWarnings("unused")
    public List<UserEntity> transformRemoteToEntityList(List<UserRemoteEntity> userRemoteEntities) {
        List<UserEntity> userEntities = new ArrayList<>();
        for (UserRemoteEntity userRemoteEntity : userRemoteEntities) {
            userEntities.add(transformRemoteToEntity(userRemoteEntity));
        }
        return userEntities;
    }

    public UserEntity transformRemoteToEntity(UserRemoteEntity userRemoteEntity) {
        UserEntity userEntity = new UserEntity();
        userEntity.setIdUser(userRemoteEntity.getIdUser());
        userEntity.setPseudoUser(userRemoteEntity.getPseudoUser());
        userEntity.setPasswordUser(userRemoteEntity.getPasswordUser());
        return userEntity;
    }

    @SuppressWarnings("unused")
    public List<UserRemoteEntity> transformEntityToRemoteList(List<UserEntity> userEntities) {
        List<UserRemoteEntity> userRemoteEntities = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            userRemoteEntities.add(transformEntityToRemote(userEntity));
        }
        return userRemoteEntities;
    }

    public UserRemoteEntity transformEntityToRemote(UserEntity userEntity) {
        UserRemoteEntity userRemoteEntity = new UserRemoteEntity();
        userRemoteEntity.setIdUser(userEntity.getIdUser());
        userRemoteEntity.setPseudoUser(userEntity.getPseudoUser());
        userRemoteEntity.setPasswordUser(userEntity.getPasswordUser());
        return userRemoteEntity;
    }
}

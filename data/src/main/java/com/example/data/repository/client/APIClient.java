package com.example.data.repository.client;

import com.example.data.entity.ProgramEntity;
import com.example.data.entity.TextEntity;
import com.example.data.entity.UserEntity;
import com.example.data.entity.remote.ProgramRemoteEntity;
import com.example.data.entity.remote.TextRemoteEntity;
import com.example.data.entity.remote.UserRemoteEntity;
import com.example.data.mapper.remote.ProgramRemoteEntityDataMapper;
import com.example.data.mapper.remote.TextRemoteEntityDataMapper;
import com.example.data.mapper.remote.UserRemoteEntityDataMapper;
import com.example.data.module.APIModule;
import com.example.data.module.APIModuleRetrofitImpl;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Client using the APIModule.
 */
public class APIClient {

    private final APIModule apiModule;
    private ProgramRemoteEntityDataMapper programRemoteEntityDataMapper;
    private UserRemoteEntityDataMapper userRemoteEntityDataMapper;
    private TextRemoteEntityDataMapper textRemoteEntityDataMapper;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public APIClient(APIModuleRetrofitImpl apiModule, ProgramRemoteEntityDataMapper programRemoteEntityDataMapper, UserRemoteEntityDataMapper userRemoteEntityDataMapper, TextRemoteEntityDataMapper textRemoteEntityDataMapper) {
        this.apiModule = apiModule;
        this.programRemoteEntityDataMapper = programRemoteEntityDataMapper;
        this.userRemoteEntityDataMapper = userRemoteEntityDataMapper;
        this.textRemoteEntityDataMapper = textRemoteEntityDataMapper;
    }

    public Observable<ProgramEntity> getProgramFromId(int idProgram) {
        return apiModule.getProgramById(idProgram).map(new Func1<ProgramRemoteEntity, ProgramEntity>() {
            @Override
            public ProgramEntity call(ProgramRemoteEntity programRemoteEntity) {
                return programRemoteEntityDataMapper.transformRemoteToEntity(programRemoteEntity);
            }
        });
    }

    public Observable<TextEntity> getTextIntroProgram(int idText) {
        return apiModule.getTextIntroProgram(idText).map(new Func1<TextRemoteEntity, TextEntity>() {
            @Override
            public TextEntity call(TextRemoteEntity textRemoteEntity) {
                return textRemoteEntityDataMapper.transformRemoteToEntity(textRemoteEntity);
            }
        });
    }

    public Observable<UserEntity> connectUser(String username, String password) {
        return apiModule.connectUser(username, password).map(new Func1<UserRemoteEntity, UserEntity>() {
            @Override
            public UserEntity call(UserRemoteEntity userRemoteEntity) {
                return userRemoteEntityDataMapper.transformRemoteToEntity(userRemoteEntity);
            }
        });
    }

    public Observable<List<ProgramEntity>> retrieveProgramsListByUserId(int userId) {
        return apiModule.retrieveProgramsListByUserId(userId).map(new Func1<List<ProgramRemoteEntity>, List<ProgramEntity>>() {
            @Override
            public List<ProgramEntity> call(List<ProgramRemoteEntity> programRemoteEntities) {
                return programRemoteEntityDataMapper.transformRemoteToEntityList(programRemoteEntities);
            }
        });
    }
}

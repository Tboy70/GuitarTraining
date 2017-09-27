package com.example.data.repository.client;

import com.example.data.entity.ExerciseEntity;
import com.example.data.entity.ProgramEntity;
import com.example.data.entity.TextEntity;
import com.example.data.entity.UserEntity;
import com.example.data.entity.remote.ExerciseRemoteEntity;
import com.example.data.entity.remote.ProgramRemoteEntity;
import com.example.data.entity.remote.TextRemoteEntity;
import com.example.data.entity.remote.UserRemoteEntity;
import com.example.data.mapper.db.ProgramDBEntityDataMapper;
import com.example.data.mapper.remote.ExerciseRemoteEntityDataMapper;
import com.example.data.mapper.remote.ProgramRemoteEntityDataMapper;
import com.example.data.mapper.remote.TextRemoteEntityDataMapper;
import com.example.data.mapper.remote.UserRemoteEntityDataMapper;
import com.example.data.module.APIModule;
import com.example.data.module.APIModuleRetrofitImpl;
import com.example.data.module.db.ModuleDB;
import com.example.data.module.db.ModuleDBFlowImpl;
import com.example.model.Exercise;
import com.example.model.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Response;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Client using the APIModule.
 */
@Singleton
public class APIClient {

    private final APIModule apiModule;
    private ModuleDB moduleDB;
    private ProgramRemoteEntityDataMapper programRemoteEntityDataMapper;
    private ExerciseRemoteEntityDataMapper exerciseRemoteEntityDataMapper;
    private ProgramDBEntityDataMapper programDBEntityDataMapper;
    private UserRemoteEntityDataMapper userRemoteEntityDataMapper;
    private TextRemoteEntityDataMapper textRemoteEntityDataMapper;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public APIClient(APIModuleRetrofitImpl apiModule, ModuleDBFlowImpl moduleDB,
                     ProgramRemoteEntityDataMapper programRemoteEntityDataMapper,
                     ExerciseRemoteEntityDataMapper exerciseRemoteEntityDataMapper,
                     ProgramDBEntityDataMapper programDBEntityDataMapper,
                     UserRemoteEntityDataMapper userRemoteEntityDataMapper,
                     TextRemoteEntityDataMapper textRemoteEntityDataMapper) {
        this.apiModule = apiModule;
        this.moduleDB = moduleDB;
        this.programRemoteEntityDataMapper = programRemoteEntityDataMapper;
        this.exerciseRemoteEntityDataMapper = exerciseRemoteEntityDataMapper;
        this.programDBEntityDataMapper = programDBEntityDataMapper;
        this.userRemoteEntityDataMapper = userRemoteEntityDataMapper;
        this.textRemoteEntityDataMapper = textRemoteEntityDataMapper;
    }

    public Observable<ProgramEntity> getProgramFromId(String idProgram) {
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

    public Observable<UserEntity> connectUser(UserEntity userEntity) {
        return apiModule.connectUser(userRemoteEntityDataMapper.transformEntityToRemote(userEntity)).map(new Func1<UserRemoteEntity, UserEntity>() {
            @Override
            public UserEntity call(UserRemoteEntity userRemoteEntity) {
                return userRemoteEntityDataMapper.transformRemoteToEntity(userRemoteEntity);
            }
        });
    }

    public Observable<List<ProgramEntity>> retrieveProgramsListByUserId(String userId) {
        return apiModule.retrieveProgramsListByUserId(userId).map(new Func1<List<ProgramRemoteEntity>, List<ProgramEntity>>() {
            @Override
            public List<ProgramEntity> call(List<ProgramRemoteEntity> programRemoteEntities) {
                return programRemoteEntityDataMapper.transformRemoteToEntityList(programRemoteEntities);
            }
        }).doOnNext(new Action1<List<ProgramEntity>>() {
            @Override
            public void call(List<ProgramEntity> programEntities) {
                moduleDB.deleteAllPrograms();
                moduleDB.saveProgramsList(programDBEntityDataMapper.transformToDBEntity(programEntities));
            }
        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends List<ProgramEntity>>>() {
            @Override
            public Observable<? extends List<ProgramEntity>> call(Throwable throwable) {
                return Observable.just(programDBEntityDataMapper.transform(moduleDB.getProgramsList()));
            }
        });
    }

    public Observable<ProgramEntity> createProgram(final ProgramEntity programEntity) {
        return apiModule.createProgram(programRemoteEntityDataMapper.transformEntityToRemote(programEntity)).map(new Func1<String, ProgramEntity>() {
            @Override
            public ProgramEntity call(String createdId) {
                if (createdId != null) {
                    programEntity.setIdProgram(createdId);
                    moduleDB.createProgram(programDBEntityDataMapper.transform(programEntity));
                    return programEntity;
                } else {
                    return null;
                }

                }
            });
        }

    public Observable<Boolean> createExercise(final List<ExerciseEntity> exerciseEntity) {
        return apiModule.createExercise(exerciseRemoteEntityDataMapper.transformEntityToRemoteList(exerciseEntity));
    }
}

package com.example.data.module;

import com.example.data.entity.remote.ExerciseRemoteEntity;
import com.example.data.entity.remote.ProgramRemoteEntity;
import com.example.data.entity.remote.TextRemoteEntity;
import com.example.data.entity.remote.UserRemoteEntity;
import com.example.data.entity.remote.program.ProgramResponseRemoteEntity;
import com.example.model.Exercise;
import com.example.model.User;

import java.util.List;

import retrofit2.Response;
import rx.Observable;

/**
 * Interface implemented by APIModuleRetrofitImpl class.
 */
public interface APIModule {

    Observable<UserRemoteEntity> connectUser(UserRemoteEntity userRemoteEntity);

    Observable<TextRemoteEntity> getTextIntroProgram(int idText);

    Observable<ProgramRemoteEntity> getProgramById(String idProgram);

    Observable<List<ProgramRemoteEntity>> retrieveProgramsListByUserId(String userId);

    Observable<String> createProgram(ProgramRemoteEntity programRemoteEntity);

    Observable<Boolean> createExercise(List<ExerciseRemoteEntity> exerciseRemoteEntity);

    Observable<Boolean> removeProgram(String idProgram);
}

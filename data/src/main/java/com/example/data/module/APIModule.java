package com.example.data.module;

import com.example.data.entity.remote.ProgramRemoteEntity;
import com.example.data.entity.remote.TextRemoteEntity;
import com.example.data.entity.remote.UserRemoteEntity;

import java.util.List;

import rx.Observable;

/**
 * Interface implemented by APIModuleRetrofitImpl class.
 */
public interface APIModule {

    Observable<UserRemoteEntity> connectUser(String username, String password);

    Observable<TextRemoteEntity> getTextIntroProgram(int idText);

    Observable<ProgramRemoteEntity> getProgramById(int idProgram);

    Observable<List<ProgramRemoteEntity>> retrieveProgramsListByUserId(int userId);
}

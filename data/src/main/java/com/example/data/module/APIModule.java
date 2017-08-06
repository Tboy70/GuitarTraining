package com.example.data.module;

import com.example.data.entity.ProgramEntity;
import com.example.data.entity.TextEntity;
import com.example.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * Interface implements by APIModuleRetrofitImpl class.
 * Contains declarations of API methods.
 */
public interface APIModule {

    Observable<List<UserEntity>> getAllUsers();

    Observable<TextEntity> getInformationTextAboutApplication();

    Observable<ProgramEntity> getProgramById(int idProgram);

    Observable<TextEntity> getTextIntroProgram(int idText);

    Observable<UserEntity> connectUser(String username, String password);
}

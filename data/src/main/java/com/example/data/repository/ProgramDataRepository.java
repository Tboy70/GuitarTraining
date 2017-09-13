package com.example.data.repository;

import com.example.data.entity.ProgramEntity;
import com.example.data.mapper.ProgramEntityDataMapper;
import com.example.data.repository.client.APIClient;
import com.example.model.Program;
import com.example.repository.ProgramRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

public class ProgramDataRepository implements ProgramRepository {

    private final ProgramEntityDataMapper programEntityDataMapper;
    private APIClient apiClient;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ProgramDataRepository(ProgramEntityDataMapper programEntityDataMapper, APIClient apiClient) {
        this.programEntityDataMapper = programEntityDataMapper;
        this.apiClient = apiClient;
    }

    @Override
    public Observable<Program> getProgramFromId(final int idProgram) {
        return apiClient.getProgramFromId(idProgram).map(new Func1<ProgramEntity, Program>() {
            @Override
            public Program call(ProgramEntity programEntity) {
                return programEntityDataMapper.transformEntityToModel(programEntity);
            }
        });
    }

    @Override
    public Observable<List<Program>> retrieveProgramsListByUserId(int userId) {
        return apiClient.retrieveProgramsListByUserId(userId).map(new Func1<List<ProgramEntity>, List<Program>>() {
            @Override
            public List<Program> call(List<ProgramEntity> programEntities) {
                return programEntityDataMapper.transformEntityToModelList(programEntities);
            }
        });
    }
}

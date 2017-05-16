package com.example.data.repository;

import com.example.data.entity.ProgramEntity;
import com.example.data.mapper.ProgramMapper;
import com.example.data.repository.client.APIClient;
import com.example.model.Program;
import com.example.repository.ProgramRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Thomas on 04/05/2017.
 */

public class ProgramDataRepository implements ProgramRepository {

    private final ProgramMapper programMapper;
    private APIClient apiClient;

    @Inject
    public ProgramDataRepository(ProgramMapper programMapper, APIClient apiClient) {
        this.programMapper = programMapper;
        this.apiClient = apiClient;
    }

    @Override
    public Observable<Program> getProgramFromId(final int idProgram) {
        return apiClient.getProgramFromId(idProgram).flatMap(new Func1<ProgramEntity, Observable<Program>>() {
            @Override
            public Observable<Program> call(ProgramEntity programEntity) {
                Program program = programMapper.transformToModel(programEntity);
                return Observable.just(program);
            }
        });
    }
}

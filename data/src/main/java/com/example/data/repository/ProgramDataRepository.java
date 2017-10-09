package com.example.data.repository;

import com.example.data.entity.ProgramEntity;
import com.example.data.mapper.ExerciseEntityDataMapper;
import com.example.data.mapper.ProgramEntityDataMapper;
import com.example.data.repository.client.APIClient;
import com.example.data.repository.client.ProgramClient;
import com.example.model.Exercise;
import com.example.model.Program;
import com.example.repository.ProgramRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

public class ProgramDataRepository implements ProgramRepository {

    private final ProgramEntityDataMapper programEntityDataMapper;
    private final ExerciseEntityDataMapper exerciseEntityDataMapper;
    private APIClient apiClient;
    private ProgramClient programClient;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ProgramDataRepository(ProgramEntityDataMapper programEntityDataMapper,
                                 ExerciseEntityDataMapper exerciseEntityDataMapper,
                                 APIClient apiClient,
                                 ProgramClient programClient) {
        this.programEntityDataMapper = programEntityDataMapper;
        this.exerciseEntityDataMapper = exerciseEntityDataMapper;
        this.apiClient = apiClient;
        this.programClient = programClient;
    }

    @Override
    public Observable<Program> getProgramFromId(String idProgram) {
        return apiClient.getProgramFromId(idProgram).map(new Func1<ProgramEntity, Program>() {
            @Override
            public Program call(ProgramEntity programEntity) {
                return programEntityDataMapper.transformEntityToModel(programEntity);
            }
        });
    }

    @Override
    public Observable<List<Program>> retrieveProgramsListByUserId(String userId) {
        return apiClient.retrieveProgramsListByUserId(userId).map(new Func1<List<ProgramEntity>, List<Program>>() {
            @Override
            public List<Program> call(List<ProgramEntity> programEntities) {
                return programEntityDataMapper.transformEntityToModelList(programEntities);
            }
        });
    }

    @Override
    public Observable<Program> retrieveProgramById(final String programId) {
        return Observable.just(programEntityDataMapper.transformEntityToModel(programClient.getProgram(programId)));
    }

    @Override
    public Observable<Program> createProgram(Program program) {
        return apiClient.createProgram(programEntityDataMapper.transformModelToEntity(program)).map(new Func1<ProgramEntity, Program>() {
            @Override
            public Program call(ProgramEntity programEntity) {
                return programEntityDataMapper.transformEntityToModel(programEntity);
            }
        });
    }

    @Override
    public Observable<Boolean> createExercise(List<Exercise> exercise) {
        return apiClient.createExercise(exerciseEntityDataMapper.transformModelToEntityList(exercise));
    }

    @Override
    public Observable<Boolean> removeProgram(String idExercise) {
        return apiClient.removeProgram(idExercise);
    }
}

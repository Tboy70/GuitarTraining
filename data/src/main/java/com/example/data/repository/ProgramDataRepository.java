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
import rx.functions.Func0;
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
    public Observable<Program> getProgramFromId(final String idProgram) {
        return Observable.defer(new Func0<Observable<Program>>() {
            @Override
            public Observable<Program> call() {
                try {
                    return apiClient.getProgramFromId(idProgram).map(new Func1<ProgramEntity, Program>() {
                        @Override
                        public Program call(ProgramEntity programEntity) {
                            return programEntityDataMapper.transformEntityToModel(programEntity);
                        }
                    });
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        });
    }

    @Override
    public Observable<List<Program>> retrieveProgramsListByUserId(final String userId) {
        return Observable.defer(new Func0<Observable<List<Program>>>() {
            @Override
            public Observable<List<Program>> call() {
                try {
                    return apiClient.retrieveProgramsListByUserId(userId).map(new Func1<List<ProgramEntity>, List<Program>>() {
                        @Override
                        public List<Program> call(List<ProgramEntity> programEntities) {
                            return programEntityDataMapper.transformEntityToModelList(programEntities);
                        }
                    });

                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        });
    }

    @Override
    public Observable<Program> retrieveProgramById(final String programId) {
        return Observable.defer(new Func0<Observable<Program>>() {
            @Override
            public Observable<Program> call() {
                try {
                    return Observable.just(programEntityDataMapper.transformEntityToModel(programClient.getProgram(programId)));
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        });
    }

    @Override
    public Observable<Program> createProgram(final Program program) {
        return Observable.defer(new Func0<Observable<Program>>() {
            @Override
            public Observable<Program> call() {
                try {
                    return apiClient.createProgram(programEntityDataMapper.transformModelToEntity(program)).map(new Func1<ProgramEntity, Program>() {
                        @Override
                        public Program call(ProgramEntity programEntity) {
                            return programEntityDataMapper.transformEntityToModel(programEntity);
                        }
                    });
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        });
    }

    @Override
    public Observable<Boolean> createExercise(final List<Exercise> exercise) {
        return Observable.defer(new Func0<Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call() {
                try {
                    return apiClient.createExercise(exerciseEntityDataMapper.transformModelToEntityList(exercise));
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        });
    }

    @Override
    public Observable<Boolean> removeProgram(final String idExercise) {
        return Observable.defer(new Func0<Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call() {
                try {
                    return apiClient.removeProgram(idExercise);
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        });
    }

    @Override
    public Observable<Boolean> updateProgramAndRemoveExercises(final Program program, final List<Exercise> exercisesToBeRemoved) {
        return Observable.defer(new Func0<Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call() {
                try {
                    return apiClient.updateProgramAndRemoveExercises(programEntityDataMapper.transformModelToEntity(program),
                            exerciseEntityDataMapper.transformModelToEntityList(exercisesToBeRemoved));
                } catch (Exception e) {
                    return Observable.error(e);
                }
            }
        });
    }
}

package com.example.interactor.program;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.repository.ProgramRepository;

import javax.inject.Inject;

import rx.Observable;

public class RemoveProgram extends UseCase<RemoveProgram.Params> {

    private ProgramRepository programRepository;

    @Inject
    public RemoveProgram(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ProgramRepository programRepository) {
        super(threadExecutor, postExecutionThread);
        this.programRepository = programRepository;
    }

    @Override
    public Observable buildUseCaseObservable(RemoveProgram.Params params) {
        // TODO: 26/09/2017 Make an exercise repository ?
        return programRepository.removeProgram(params.idExercise);
    }

    public static final class Params {
        private String idExercise;

        private Params(String idExercise) {
            this.idExercise = idExercise;
        }

        public static RemoveProgram.Params forSuppression(String idExercise) {
            return new RemoveProgram.Params(idExercise);
        }
    }
}

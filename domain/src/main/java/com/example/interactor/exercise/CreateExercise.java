package com.example.interactor.exercise;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.model.Exercise;
import com.example.repository.ProgramRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;


public class CreateExercise extends UseCase<CreateExercise.Params> {

    private ProgramRepository programRepository;

    @Inject
    public CreateExercise(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ProgramRepository programRepository) {
        super(threadExecutor, postExecutionThread);
        this.programRepository = programRepository;
    }

    @Override
    public Observable buildUseCaseObservable(CreateExercise.Params params) {
        // TODO: 26/09/2017 Make an exercise repository ?
        return programRepository.createExercise(params.exercise);
    }

    public static final class Params {
        private List<Exercise> exercise;

        private Params(List<Exercise> exercise) {
            this.exercise = exercise;
        }

        public static Params forCreation(List<Exercise> exercise) {
            return new CreateExercise.Params(exercise);
        }
    }
}

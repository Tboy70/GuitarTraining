package com.example.interactor.program;


import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.model.Exercise;
import com.example.model.Program;
import com.example.repository.ProgramRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class UpdateProgramAndRemoveExercises extends UseCase<UpdateProgramAndRemoveExercises.Params> {

    private ProgramRepository programRepository;

    @Inject
    public UpdateProgramAndRemoveExercises(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ProgramRepository programRepository) {
        super(threadExecutor, postExecutionThread);
        this.programRepository = programRepository;
    }

    @Override
    public Observable buildUseCaseObservable(UpdateProgramAndRemoveExercises.Params params) {
        return programRepository.updateProgramAndRemoveExercises(params.program, params.exercisesToBeRemoved);
    }

    public static final class Params {
        private Program program;
        private List<Exercise> exercisesToBeRemoved;

        private Params(Program program, List<Exercise> exercisesToBeRemoved) {
            this.program = program;
            this.exercisesToBeRemoved = exercisesToBeRemoved;
        }

        public static UpdateProgramAndRemoveExercises.Params forUpdate(Program program, List<Exercise> exercisesToBeRemoved) {
            return new UpdateProgramAndRemoveExercises.Params(program, exercisesToBeRemoved);
        }
    }
}

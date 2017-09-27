package com.example.interactor.program;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.model.Program;
import com.example.repository.ProgramRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class CreateProgram extends UseCase<CreateProgram.Params> {

    private ProgramRepository programRepository;

    @Inject
    public CreateProgram(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ProgramRepository programRepository) {
        super(threadExecutor, postExecutionThread);
        this.programRepository = programRepository;
    }

    @Override
    public Observable buildUseCaseObservable(CreateProgram.Params params) {
        return programRepository.createProgram(params.program);
    }

    public static final class Params {
        private Program program;

        private Params(Program program) {
            this.program = program;
        }

        public static CreateProgram.Params forCreation(Program program) {
            return new CreateProgram.Params(program);
        }
    }
}

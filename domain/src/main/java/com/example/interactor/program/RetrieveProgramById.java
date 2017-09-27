package com.example.interactor.program;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.repository.ProgramRepository;

import javax.inject.Inject;

import rx.Observable;


public class RetrieveProgramById extends UseCase<RetrieveProgramById.Params> {

    private ProgramRepository programRepository;

    @Inject
    public RetrieveProgramById(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ProgramRepository programRepository) {
        super(threadExecutor, postExecutionThread);
        this.programRepository = programRepository;
    }

    @Override
    public Observable buildUseCaseObservable(RetrieveProgramById.Params params) {
        return programRepository.retrieveProgramById(params.programId);
    }

    public static final class Params {
        private final String programId;

        private Params(String programId) {
            this.programId = programId;
        }

        public static RetrieveProgramById.Params forProgram(String programId) {
            return new RetrieveProgramById.Params(programId);
        }
    }
}

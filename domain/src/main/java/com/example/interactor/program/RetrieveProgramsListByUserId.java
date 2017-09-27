package com.example.interactor.program;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.repository.ProgramRepository;

import javax.inject.Inject;

import rx.Observable;

public class RetrieveProgramsListByUserId extends UseCase<RetrieveProgramsListByUserId.Params> {

    private ProgramRepository programRepository;

    @Inject
    public RetrieveProgramsListByUserId(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ProgramRepository programRepository) {
        super(threadExecutor, postExecutionThread);
        this.programRepository = programRepository;
    }

    @Override
    public Observable buildUseCaseObservable(Params params) {
        return programRepository.retrieveProgramsListByUserId(params.userId);
    }

    public static final class Params {
        private final String userId;

        private Params(String userId) {
            this.userId = userId;
        }

        public static Params forList(String userId) {
            return new RetrieveProgramsListByUserId.Params(userId);
        }
    }
}

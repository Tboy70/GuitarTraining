package com.example.interactor.program;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.repository.ProgramRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetProgramFromId extends UseCase<GetProgramFromId.Params> {

    private ProgramRepository programRepository;

    @Inject
    public GetProgramFromId(ThreadExecutor io, PostExecutionThread scheduler, ProgramRepository programRepository) {
        super(io, scheduler);
        this.programRepository = programRepository;
    }

    @Override
    public Observable buildUseCaseObservable(Params params) {
        return programRepository.getProgramFromId(params.idProgram);
    }

    public static final class Params {
        private final int idProgram;

        private Params(int idProgram) {
            this.idProgram = idProgram;
        }

        public static Params toGet(int idProgram) {
            return new Params(idProgram);
        }
    }
}

package com.example.interactor;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.ProgramRepository;

import rx.Observable;

public class GetProgramFromId extends UseCase {

    private ProgramRepository programRepository;
    private int idProgram;

    public GetProgramFromId(ThreadExecutor io, PostExecutionThread scheduler, ProgramRepository programRepository, int idProgram) {
        super(io, scheduler);
        this.programRepository = programRepository;
        this.idProgram = idProgram;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return programRepository.getProgramFromId(idProgram);
    }
}

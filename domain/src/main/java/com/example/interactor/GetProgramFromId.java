package com.example.interactor;

import com.example.model.Program;
import com.example.repository.ProgramRepository;

import rx.Scheduler;
import rx.Subscriber;

/**
 * Created by Thomas on 08/05/2017.
 */

public class GetProgramFromId {

    private ProgramRepository programRepository;
    private Scheduler io;
    private Scheduler scheduler;

    public GetProgramFromId(Scheduler io, Scheduler scheduler, ProgramRepository programRepository) {
        this.io = io;
        this.scheduler = scheduler;
        this.programRepository = programRepository;
    }

    public void buildUseCaseObservable(int idProgram, Subscriber<Program> subscriber) {
        programRepository.getProgramFromId(idProgram)
                .subscribeOn(io)
                .observeOn(scheduler)
                .subscribe(subscriber);
    }
}

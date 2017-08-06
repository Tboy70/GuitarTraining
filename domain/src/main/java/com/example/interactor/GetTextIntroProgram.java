package com.example.interactor;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.TextRepository;

import rx.Observable;

/**
 * Created by Thomas on 17/05/2017.
 */

public class GetTextIntroProgram extends UseCase {

    private TextRepository textRepository;
    private int idProgram;

    public GetTextIntroProgram(ThreadExecutor io, PostExecutionThread scheduler, TextRepository textRepository, int idProgram) {
        super(io, scheduler);
        this.textRepository = textRepository;
        this.idProgram = idProgram;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return textRepository.getTextIntroProgram(idProgram);
    }
}

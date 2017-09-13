package com.example.interactor.text;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.repository.TextRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetTextIntroProgram extends UseCase<GetTextIntroProgram.Params> {

    private TextRepository textRepository;

    @Inject
    public GetTextIntroProgram(ThreadExecutor io, PostExecutionThread scheduler, TextRepository textRepository) {
        super(io, scheduler);
        this.textRepository = textRepository;
    }

    @Override
    public Observable buildUseCaseObservable(Params params) {
        return textRepository.getTextIntroProgram(params.idProgram);
    }

    public static final class Params {
        private final int idProgram;

        private Params(int idProgram) {
            this.idProgram = idProgram;
        }

        public static GetTextIntroProgram.Params toGet(int idProgram) {
            return new GetTextIntroProgram.Params(idProgram);
        }
    }
}

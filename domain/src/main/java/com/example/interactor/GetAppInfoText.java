package com.example.interactor;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.TextRepository;

import rx.Observable;

/**
 * Use case to get the application information.
 */
public class GetAppInfoText extends UseCase {

    private TextRepository textRepository;

    public GetAppInfoText(ThreadExecutor io, PostExecutionThread scheduler, TextRepository textRepository) {
        super(io, scheduler);
        this.textRepository = textRepository;
    }

    /**
     * Method from the Use Case general class.
     *
     * @return a observable.
     */
    @Override
    public Observable buildUseCaseObservable() {
        return textRepository.getApplicationAboutInformation();
    }
}

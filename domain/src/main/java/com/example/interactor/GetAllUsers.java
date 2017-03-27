package com.example.interactor;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.UserRepository;

import rx.Observable;

/**
 * Use case to retrieve all the users of the application.
 */
public class GetAllUsers extends UseCase {

    private UserRepository userRepository;

    public GetAllUsers(ThreadExecutor io, PostExecutionThread scheduler, UserRepository userRepository) {
        super(io, scheduler);
        this.userRepository = userRepository;
    }

    /**
     * Method from the Use Case general class.
     * @return a observable.
     */
    @Override
    public Observable buildUseCaseObservable() {
        return userRepository.getAllUsers();
    }
}

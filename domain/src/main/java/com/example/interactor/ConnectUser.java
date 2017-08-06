package com.example.interactor;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.UserRepository;

import rx.Observable;

public class ConnectUser extends UseCase {

    private UserRepository userRepository;
    private String username;
    private String password;

    public ConnectUser(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserRepository userRepository, String username, String password) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
        this.username = username;
        this.password = password;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return userRepository.connectUser(username, password);
    }
}

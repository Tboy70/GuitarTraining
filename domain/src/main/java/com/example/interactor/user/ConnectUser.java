package com.example.interactor.user;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

public class ConnectUser extends UseCase<ConnectUser.Params> {

    private UserRepository userRepository;

    @Inject
    public ConnectUser(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    public Observable buildUseCaseObservable(Params params) {
        return userRepository.connectUser(params.username, params.password);
    }

    public static final class Params {
        private final String username;
        private final String password;

        private Params(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public static Params forLogin(String username, String password) {
            return new Params(username, password);
        }
    }
}

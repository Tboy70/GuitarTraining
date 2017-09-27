package com.example.interactor.user;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.model.User;
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
        return userRepository.connectUser(params.user);
    }

    public static final class Params {
        private final User user;

        private Params(User user) {
            this.user = user;
        }

        public static Params forLogin(User user) {
            return new Params(user);
        }
    }
}

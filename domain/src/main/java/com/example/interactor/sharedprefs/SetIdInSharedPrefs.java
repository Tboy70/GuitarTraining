package com.example.interactor.sharedprefs;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

public class SetIdInSharedPrefs extends UseCase<SetIdInSharedPrefs.Params> {

    private UserRepository userRepository;

    @Inject
    public SetIdInSharedPrefs(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    public Observable<Boolean> buildUseCaseObservable(Params params) {
        return userRepository.setIdUserInSharedPrefs(params.idUser);
    }

    public static final class Params {
        private final String idUser;

        private Params(String idUser) {
            this.idUser = idUser;
        }

        public static Params forSetting(String idUser) {
            return new Params(idUser);
        }
    }
}

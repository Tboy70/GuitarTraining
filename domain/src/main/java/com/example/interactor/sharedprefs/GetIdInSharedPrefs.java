package com.example.interactor.sharedprefs;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.UseCase;
import com.example.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;


public class GetIdInSharedPrefs extends UseCase<Void> {

    private UserRepository userRepository;

    @Inject
    public GetIdInSharedPrefs(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable buildUseCaseObservable(Void aVoid) {
        return userRepository.getIdInSharedPrefs();
    }
}

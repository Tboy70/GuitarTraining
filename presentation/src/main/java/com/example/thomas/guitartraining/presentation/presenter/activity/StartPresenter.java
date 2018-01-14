package com.example.thomas.guitartraining.presentation.presenter.activity;

import android.util.Log;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.sharedprefs.GetIdInSharedPrefs;
import com.example.thomas.guitartraining.presentation.activity.listener.StartNavigatorListener;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Presenter of the main activity.
 */
public class StartPresenter {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private StartNavigatorListener startNavigatorListener;

    private GetIdInSharedPrefs getIdInSharedPrefs;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public StartPresenter(BaseNavigatorListener baseNavigatorListener, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread
            , GetIdInSharedPrefs getIdInSharedPrefs) {
        if (baseNavigatorListener instanceof StartNavigatorListener) {
            this.startNavigatorListener = (StartNavigatorListener) baseNavigatorListener;
        }
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.getIdInSharedPrefs = getIdInSharedPrefs;
    }

    public void getUserPrefIsConnected() {
        getIdInSharedPrefs.execute(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("TEST", "onError: ");
            }

            @Override
            public void onNext(String idUser) {
                startNavigatorListener.launchRightScreen(idUser);
            }
        }, null);
    }
}

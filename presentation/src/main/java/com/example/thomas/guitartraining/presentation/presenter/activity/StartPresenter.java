package com.example.thomas.guitartraining.presentation.presenter.activity;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.thomas.guitartraining.presentation.activity.listener.StartNavigatorListener;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

import javax.inject.Inject;

/**
 * Presenter of the main activity.
 */
public class StartPresenter {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private StartNavigatorListener startNavigatorListener;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public StartPresenter(BaseNavigatorListener baseNavigatorListener, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        if (baseNavigatorListener instanceof StartNavigatorListener) {
            this.startNavigatorListener = (StartNavigatorListener) baseNavigatorListener;
        }
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }
}

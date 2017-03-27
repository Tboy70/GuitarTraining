package com.example.thomas.guitartraining.presentation.executor;

import com.example.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * DO NOT TOUCH : Class for the asynchronous tasks.
 */
@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    @SuppressWarnings("WeakerAccess")
    public UIThread() {}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}

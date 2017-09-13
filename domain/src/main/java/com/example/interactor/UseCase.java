package com.example.interactor;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * DO NOT TOUCH : Generic class for the use cases.
 */
public abstract class UseCase<Params> {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Subscription subscription = Subscriptions.empty();

    protected UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @SuppressWarnings("unchecked")
    public void execute(Subscriber useCaseSubscriber, Params params) {
        this.subscription = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(useCaseSubscriber);
    }

    @SuppressWarnings("unused")
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    protected abstract Observable buildUseCaseObservable(Params params);
}

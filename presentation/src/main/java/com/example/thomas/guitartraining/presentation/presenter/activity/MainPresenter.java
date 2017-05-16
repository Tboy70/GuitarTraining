package com.example.thomas.guitartraining.presentation.presenter.activity;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.GetAppInfoText;
import com.example.interactor.UseCase;
import com.example.model.Text;
import com.example.repository.TextRepository;
import com.example.thomas.guitartraining.presentation.view.MainNavigatorListener;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Presenter of the main activity.
 */
public class MainPresenter {

    private MainNavigatorListener mainNavigatorListener;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private TextRepository textRepository;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public MainPresenter(MainNavigatorListener mainNavigatorListener, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                         TextRepository textRepository) {
        this.mainNavigatorListener = mainNavigatorListener;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.textRepository = textRepository;
    }

    /**
     * Get the information about the application.
     */
    public void getAppInfoText() {
        UseCase getAppInfoText = new GetAppInfoText(threadExecutor, postExecutionThread, textRepository);
        getAppInfoText.execute(new Subscriber<Text>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Text text) {
                mainNavigatorListener.callDialogFragment(text);
            }
        });
    }
}

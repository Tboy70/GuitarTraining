package com.example.thomas.guitartraining.presentation.presenter;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.thomas.guitartraining.presentation.fragment.ListUsersFragment;
import com.example.thomas.guitartraining.presentation.view.ListUsersView;
import com.example.thomas.guitartraining.presentation.view.MainNavigatorListener;

import javax.inject.Inject;

/**
 * Created by Thomas on 13/03/2017.
 */

public class ListUsersPresenter {

    private ListUsersView listUsersView;
    private MainNavigatorListener mainNavigatorListener;

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    @Inject
    ListUsersPresenter(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    public void setListUsersView(ListUsersFragment listUsersView) {
        this.listUsersView = listUsersView;
    }

    public void setMainNavigatorListener(MainNavigatorListener mainNavigatorListener) {
        this.mainNavigatorListener = mainNavigatorListener;
    }
}

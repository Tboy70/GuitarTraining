package com.example.thomas.guitartraining.presentation.presenter;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.GetAllUsers;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.thomas.guitartraining.presentation.fragment.ListUsersFragment;
import com.example.thomas.guitartraining.presentation.view.ListUsersView;
import com.example.thomas.guitartraining.presentation.view.MainNavigatorListener;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Presenter for the fragment ListUsers.
 */
public class ListUsersPresenter {

    private ListUsersView listUsersView;
    private MainNavigatorListener mainNavigatorListener;
    private UserRepository userRepository;

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    @Inject
    ListUsersPresenter(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.userRepository = userRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    public void setListUsersView(ListUsersFragment listUsersView) {
        this.listUsersView = listUsersView;
    }

    public void setMainNavigatorListener(MainNavigatorListener mainNavigatorListener) {
        this.mainNavigatorListener = mainNavigatorListener;
    }

    public void retrieveListUsers() {
        GetAllUsers getAllUsers = new GetAllUsers(threadExecutor, postExecutionThread, userRepository);
        getAllUsers.execute(new Subscriber<List<User>>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                listUsersView.displayError("ERREUR A CHANGER");
            }

            @Override
            public void onNext(List<User> users) {
                listUsersView.updateUI(users);
            }
        });
    }
}

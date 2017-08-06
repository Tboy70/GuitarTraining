package com.example.thomas.guitartraining.presentation.presenter.user;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.ConnectUser;
import com.example.interactor.UseCase;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.LoginView;
import com.example.thomas.guitartraining.presentation.activity.listener.OnlineNavigatorListener;

import javax.inject.Inject;

import rx.Subscriber;

@PerActivity
public class LoginPresenter {

    private LoginView loginView;
    private BaseNavigatorListener baseNavigatorListener;
    private OnlineNavigatorListener onlineNavigatorListener;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private UserRepository userRepository;

    @Inject
    LoginPresenter(BaseNavigatorListener baseNavigatorListener, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                   UserRepository userRepository) {
        this.baseNavigatorListener = baseNavigatorListener;
        if (baseNavigatorListener instanceof OnlineNavigatorListener) {
            this.onlineNavigatorListener = (OnlineNavigatorListener) baseNavigatorListener;
        }
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.userRepository = userRepository;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void setOnlineNavigatorListener(OnlineNavigatorListener onlineNavigatorListener) {
        this.onlineNavigatorListener = onlineNavigatorListener;
    }

    public void connectUser(String username, String password) {
        UseCase connectUser = new ConnectUser(threadExecutor, postExecutionThread, userRepository, username, password);
        connectUser.execute(new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                baseNavigatorListener.requestRenderError(e, ErrorRendererComponent.ERROR_DISPLAY_MODE_SNACKBAR, null);
            }

            @Override
            public void onNext(User user) {
                onlineNavigatorListener.launchMainActivity();
            }
        });
    }
}

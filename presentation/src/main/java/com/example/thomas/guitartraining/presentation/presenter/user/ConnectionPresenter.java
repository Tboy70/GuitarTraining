package com.example.thomas.guitartraining.presentation.presenter.user;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.interactor.user.ConnectUser;
import com.example.interactor.sharedprefs.SetIdInSharedPrefs;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.LoginNavigatorListener;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.LoginView;

import javax.inject.Inject;

import rx.Subscriber;

@PerActivity
public class ConnectionPresenter {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private LoginView loginView;
    private BaseNavigatorListener baseNavigatorListener;
    private LoginNavigatorListener loginNavigatorListener;
    private UserRepository userRepository;

    private ConnectUser connectUser;
    private SetIdInSharedPrefs setIdInSharedPrefs;

    @Inject
    ConnectionPresenter(BaseNavigatorListener baseNavigatorListener, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                        UserRepository userRepository, ConnectUser connectUser, SetIdInSharedPrefs setIdInSharedPrefs) {
        this.baseNavigatorListener = baseNavigatorListener;
        if (baseNavigatorListener instanceof LoginNavigatorListener) {
            this.loginNavigatorListener = (LoginNavigatorListener) baseNavigatorListener;
        }
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.userRepository = userRepository;
        this.connectUser = connectUser;
        this.setIdInSharedPrefs = setIdInSharedPrefs;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void setLoginNavigatorListener(LoginNavigatorListener loginNavigatorListener) {
        this.loginNavigatorListener = loginNavigatorListener;
    }

    public void connectUser(String username, String password) {
        User user = new User();
        user.setPseudoUser(username);
        user.setPasswordUser(password);
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
                loginNavigatorListener.launchUserPanelActivity();
                setIdInSharedPrefs(user.getIdUser());
            }
        }, ConnectUser.Params.forLogin(user));
    }

    private void setIdInSharedPrefs(String idUser) {
        setIdInSharedPrefs.execute(new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        }, SetIdInSharedPrefs.Params.forSetting(idUser));
    }
}

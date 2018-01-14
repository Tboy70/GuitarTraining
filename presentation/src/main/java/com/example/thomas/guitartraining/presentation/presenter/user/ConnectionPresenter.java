package com.example.thomas.guitartraining.presentation.presenter.user;

import android.app.Activity;

import com.example.interactor.sharedprefs.SetIdInSharedPrefs;
import com.example.interactor.user.ConnectUser;
import com.example.model.User;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.LoginNavigatorListener;
import com.example.thomas.guitartraining.presentation.component.navigator.ErrorRendererComponent;
import com.example.thomas.guitartraining.presentation.component.presenter.MaterialDialogComponent;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.ConnectionView;

import javax.inject.Inject;

import rx.Subscriber;

@PerActivity
public class ConnectionPresenter {

    private ConnectionView connectionView;
    private BaseNavigatorListener baseNavigatorListener;
    private LoginNavigatorListener loginNavigatorListener;

    private ConnectUser connectUser;
    private SetIdInSharedPrefs setIdInSharedPrefs;

    private MaterialDialogComponent materialDialogComponent;

    @Inject
    ConnectionPresenter(BaseNavigatorListener baseNavigatorListener, ConnectUser connectUser, SetIdInSharedPrefs setIdInSharedPrefs,
                        MaterialDialogComponent materialDialogComponent) {
        this.baseNavigatorListener = baseNavigatorListener;
        if (baseNavigatorListener instanceof LoginNavigatorListener) {
            this.loginNavigatorListener = (LoginNavigatorListener) baseNavigatorListener;
        }
        this.connectUser = connectUser;
        this.setIdInSharedPrefs = setIdInSharedPrefs;
        this.materialDialogComponent = materialDialogComponent;
    }

    public void setConnectionView(ConnectionView connectionView) {
        this.connectionView = connectionView;
    }

    public void setLoginNavigatorListener(LoginNavigatorListener loginNavigatorListener) {
        this.loginNavigatorListener = loginNavigatorListener;
    }

    public void connectUser(Activity activity, String username, String password) {
        materialDialogComponent.showProgressDialog(activity, activity.getString(R.string.login_dialog_title),
                activity.getString(R.string.login_dialog_content), R.color.colorPrimary);
        User user = new User();
        user.setPseudoUser(username);
        user.setPasswordUser(password);
        connectUser.execute(new Subscriber<User>() {
            @Override
            public void onCompleted() {
                materialDialogComponent.dismissDialog();
            }

            @Override
            public void onError(Throwable e) {
                materialDialogComponent.dismissDialog();
                baseNavigatorListener.requestRenderError(e, ErrorRendererComponent.ERROR_DISPLAY_MODE_SNACKBAR, null);
            }

            @Override
            public void onNext(User user) {
                materialDialogComponent.dismissDialog();
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

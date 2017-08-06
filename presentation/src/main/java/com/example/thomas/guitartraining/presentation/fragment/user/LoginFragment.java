package com.example.thomas.guitartraining.presentation.fragment.user;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.OnlineActivity;
import com.example.thomas.guitartraining.presentation.presenter.user.LoginPresenter;
import com.example.thomas.guitartraining.presentation.view.user.LoginView;
import com.example.thomas.guitartraining.presentation.activity.listener.OnlineNavigatorListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment implements LoginView {

    @Inject
    LoginPresenter loginPresenter;

    @BindView(R.id.login_username)
    EditText loginUsername;

    @BindView(R.id.login_password)
    EditText loginPassword;

    View rootView;

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.login_fragment, container, false);

        ButterKnife.bind(this, rootView);
        ((OnlineActivity) getActivity()).getActivityComponent().inject(this);

        loginPresenter.setLoginView(this);
        loginPresenter.setOnlineNavigatorListener((OnlineNavigatorListener) this.getActivity());

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.login_validate)
    public void handleClickValidateLogin() {
        loginPresenter.connectUser(String.valueOf(loginUsername.getText()), String.valueOf(loginPassword.getText()));
    }

}

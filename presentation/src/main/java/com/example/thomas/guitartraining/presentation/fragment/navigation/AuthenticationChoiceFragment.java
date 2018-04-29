package com.example.thomas.guitartraining.presentation.fragment.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.fragment.BaseFragment;
import com.example.thomas.guitartraining.presentation.presenter.navigation.AuthenticationChoicePresenter;
import com.example.thomas.guitartraining.presentation.view.navigation.AuthenticationChoiceView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment containing the choice of authentication (connected mode or not).
 */
public class AuthenticationChoiceFragment extends BaseFragment implements AuthenticationChoiceView {

    @Inject
    AuthenticationChoicePresenter authenticationChoicePresenter;

    public static AuthenticationChoiceFragment newInstance() {
        return new AuthenticationChoiceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_authentication_choice, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick(R.id.fragment_authentication_choice_not_connected_button)
    public void handleClickAuthenticationChoiceNotConnectedButton() {
        authenticationChoicePresenter.launchNotConnectedActivity();
    }

    @OnClick(R.id.fragment_authentication_choice_connection_button)
    public void handleClickAuthentificationChoiceConnectionButton() {
        authenticationChoicePresenter.launchLoginActivity();
    }
}

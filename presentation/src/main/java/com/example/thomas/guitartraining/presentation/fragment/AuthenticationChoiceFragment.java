package com.example.thomas.guitartraining.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.MainActivity;
import com.example.thomas.guitartraining.presentation.presenter.AuthenticationChoicePresenter;
import com.example.thomas.guitartraining.presentation.view.AuthenticationChoiceView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment containing the choice of authentication (connected mode or not).
 */
public class AuthenticationChoiceFragment extends Fragment implements AuthenticationChoiceView {

    @Inject
    AuthenticationChoicePresenter authenticationChoicePresenter;

    View rootView;

    public static AuthenticationChoiceFragment newInstance() {
        return new AuthenticationChoiceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.main_authentication_choice, container, false);
        ((MainActivity) getActivity()).getActivityComponent().inject(this);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, rootView);
    }

    @OnClick(R.id.main_authentication_choice_offline_button)
    public void handleClickAuthenticationChoiceOfflineButton() {
        authenticationChoicePresenter.launchOfflineActivity();
    }
}

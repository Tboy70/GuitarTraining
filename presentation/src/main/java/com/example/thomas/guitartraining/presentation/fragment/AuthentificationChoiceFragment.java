package com.example.thomas.guitartraining.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.MainActivity;
import com.example.thomas.guitartraining.presentation.presenter.AuthentificationChoicePresenter;
import com.example.thomas.guitartraining.presentation.view.AuthentificationChoiceView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment containing the choice of authentification (connected mode or not).
 */
public class AuthentificationChoiceFragment extends Fragment implements AuthentificationChoiceView {

    @Inject
    AuthentificationChoicePresenter authentificationChoicePresenter;

    View rootView;

    public static AuthentificationChoiceFragment newInstance() {
        return new AuthentificationChoiceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.main_authentification_choice, container, false);
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

    @OnClick(R.id.authentification_choice_offline_button)
    public void handleAuthentificationChoiceOfflineButton() {
        authentificationChoicePresenter.launchOfflineActivity();
    }
}

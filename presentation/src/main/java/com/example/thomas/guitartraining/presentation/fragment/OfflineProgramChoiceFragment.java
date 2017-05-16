package com.example.thomas.guitartraining.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.OfflineActivity;
import com.example.thomas.guitartraining.presentation.presenter.OfflineProgramChoicePresenter;
import com.example.thomas.guitartraining.presentation.view.OfflineSessionChoiceView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment containing the choice of session.
 */
public class OfflineProgramChoiceFragment extends Fragment implements OfflineSessionChoiceView {

    @Inject
    OfflineProgramChoicePresenter offlineProgramChoicePresenter;

    View rootView;

    public static OfflineProgramChoiceFragment newInstance() {
        return new OfflineProgramChoiceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.offline_program_choice, container, false);
        ((OfflineActivity) getActivity()).getActivityComponent().inject(this);

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

    @OnClick(R.id.offline_program_choice_theoretical)
    public void handleClickOfflineProgramChoiceTheoretical() {
        offlineProgramChoicePresenter.launchProgramActivity(1);
    }
}

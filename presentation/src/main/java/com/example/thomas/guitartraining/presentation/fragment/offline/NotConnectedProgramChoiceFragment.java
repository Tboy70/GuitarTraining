package com.example.thomas.guitartraining.presentation.fragment.offline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.fragment.BaseFragment;
import com.example.thomas.guitartraining.presentation.presenter.offline.NotConnectedProgramChoicePresenter;
import com.example.thomas.guitartraining.presentation.view.offline.NotConnectedProgramChoiceView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment containing the choice of session.
 */
public class NotConnectedProgramChoiceFragment extends BaseFragment implements NotConnectedProgramChoiceView {

    @Inject
    NotConnectedProgramChoicePresenter notConnectedProgramChoicePresenter;

    private View rootView;

    public static NotConnectedProgramChoiceFragment newInstance() {
        return new NotConnectedProgramChoiceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_not_connected_program_choice, container, false);

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

    @OnClick(R.id.fragment_not_connected_program_choice_theoretical_button)
    public void handleClickNotConnectedProgramChoiceTheoreticalButton() {
        notConnectedProgramChoicePresenter.launchProgramActivity(1);
    }

    @OnClick(R.id.fragment_not_connected_program_choice_technical_button)
    public void handleClickNotConnectedProgramChoiceTechnicalButton() {
        notConnectedProgramChoicePresenter.launchProgramActivity(2);
    }
}

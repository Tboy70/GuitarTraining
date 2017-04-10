package com.example.thomas.guitartraining.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.OfflineActivity;
import com.example.thomas.guitartraining.presentation.presenter.OfflineSessionChoicePresenter;
import com.example.thomas.guitartraining.presentation.view.OfflineSessionChoiceView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Fragment containing the choice of session.
 */
public class OfflineSessionChoiceFragment extends Fragment implements OfflineSessionChoiceView {

    @Inject
    OfflineSessionChoicePresenter offlineSessionChoicePresenter;

    View rootView;

    public static OfflineSessionChoiceFragment newInstance() {
        return new OfflineSessionChoiceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.offline_session_choice, container, false);
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
}

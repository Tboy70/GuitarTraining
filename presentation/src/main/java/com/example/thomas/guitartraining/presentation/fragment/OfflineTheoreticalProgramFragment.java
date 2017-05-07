package com.example.thomas.guitartraining.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.OfflineActivity;
import com.example.thomas.guitartraining.presentation.presenter.OfflineTheoreticalProgramPresenter;
import com.example.thomas.guitartraining.presentation.view.OfflineNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.OfflineTheoreticalProgramView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Thomas on 04/05/2017.
 */

public class OfflineTheoreticalProgramFragment extends Fragment implements OfflineTheoreticalProgramView {

    @Inject
    OfflineTheoreticalProgramPresenter offlineTheoreticalProgramPresenter;

    View rootView;

    public static OfflineTheoreticalProgramFragment newInstance() {

        Bundle args = new Bundle();

        OfflineTheoreticalProgramFragment fragment = new OfflineTheoreticalProgramFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_offline_theoretical_program, container, false);
        ((OfflineActivity) getActivity()).getActivityComponent().inject(this);
        offlineTheoreticalProgramPresenter.setOfflineTheoreticalProgramView(this);
        offlineTheoreticalProgramPresenter.setOfflineNavigatorListener((OfflineNavigatorListener) this.getActivity());

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
        offlineTheoreticalProgramPresenter.getOfflineTheoreticalProgram(1);
    }
}

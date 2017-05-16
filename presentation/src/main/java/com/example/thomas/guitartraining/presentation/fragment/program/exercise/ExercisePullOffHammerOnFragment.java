package com.example.thomas.guitartraining.presentation.fragment.program.exercise;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExercisePullOffHammerOnPresenter;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExercisePullOffHammerOnView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * TODO : Should make a comment for each fragment ? Not sure --> useless
 */
public class ExercisePullOffHammerOnFragment extends Fragment implements ExercisePullOffHammerOnView {

    @Inject
    ExercisePullOffHammerOnPresenter exercisePullOffHammerOnPresenter;

    public static ExercisePullOffHammerOnFragment newInstance() {

        Bundle args = new Bundle();

        ExercisePullOffHammerOnFragment fragment = new ExercisePullOffHammerOnFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.exercise_pull_off_hammer_on_fragment, container, false);

        ButterKnife.bind(this, rootView);
        ((ProgramActivity) getActivity()).getActivityComponent().inject(this);  // TODO : Possibility to externalize this ? BaseActivity ?

        exercisePullOffHammerOnPresenter.setExercisePullOffHammerOnView(this);
        exercisePullOffHammerOnPresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

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
}

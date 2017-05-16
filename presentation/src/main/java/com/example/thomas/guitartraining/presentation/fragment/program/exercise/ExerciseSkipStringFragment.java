package com.example.thomas.guitartraining.presentation.fragment.program.exercise;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExerciseSkipStringPresenter;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseSkipStringView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Thomas on 16/05/2017.
 */

public class ExerciseSkipStringFragment extends Fragment implements ExerciseSkipStringView {
    @Inject
    ExerciseSkipStringPresenter exerciseSkipStringPresenter;

    public static ExerciseSkipStringFragment newInstance() {

        Bundle args = new Bundle();

        ExerciseSkipStringFragment fragment = new ExerciseSkipStringFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.exercise_skip_string_fragment, container, false);

        ButterKnife.bind(this, rootView);
        ((ProgramActivity) getActivity()).getActivityComponent().inject(this);  // TODO : Possibility to externalize this ? BaseActivity ?

        exerciseSkipStringPresenter.setExerciseSkipStringView(this);
        exerciseSkipStringPresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

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

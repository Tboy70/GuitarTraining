package com.example.thomas.guitartraining.presentation.fragment.program.exercise;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExercisePullOffHammerOnPresenter;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExercisePullOffHammerOnView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * TODO : Should make a comment for each fragment ? Not sure --> useless
 */
public class ExercisePullOffHammerOnFragment extends Fragment implements ExercisePullOffHammerOnView {

    public static final String RANK_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePullOffHammerOnFragment.RANK_EXERCISE";
    public static final String DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePullOffHammerOnFragment.DURATION_EXERCISE";

    @Inject
    ExercisePullOffHammerOnPresenter exercisePullOffHammerOnPresenter;

    @BindView(R.id.exercise_pull_off_hammer_on_duration)
    TextView exercisePullOffHammerOnDuration;

    private int rankExercise;

    public static ExercisePullOffHammerOnFragment newInstance(int exercisePosition, int durationExercise) {
        Bundle args = new Bundle();
        args.putInt(RANK_EXERCISE, exercisePosition);
        args.putInt(DURATION_EXERCISE, durationExercise);

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

        rankExercise = getArguments().getInt(RANK_EXERCISE);
        int durationExercise = getArguments().getInt(DURATION_EXERCISE);

        exercisePullOffHammerOnDuration.setText(String.format(getActivity().getString(R.string.exercise_duration_text),
                String.valueOf(durationExercise)));

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

    @OnClick(R.id.exercise_pull_off_hammer_on_next_button)
    public void handleClickExerciseScaleNextButton() {
        exercisePullOffHammerOnPresenter.showNextExercise(rankExercise + 1);
    }
}

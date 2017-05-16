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
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExerciseSweepPickingPresenter;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseSweepPickingView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Thomas on 16/05/2017.
 */

public class ExerciseSweepPickingFragment extends Fragment implements ExerciseSweepPickingView {

    public static final String RANK_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSweepPickingFragment.RANK_EXERCISE";
    public static final String DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSweepPickingFragment.DURATION_EXERCISE";

    @Inject
    ExerciseSweepPickingPresenter exerciseSweepPickingPresenter;

    @BindView(R.id.exercise_sweep_picking_duration)
    TextView exerciseSweepPickingDuration;

    private int rankExercise;

    public static ExerciseSweepPickingFragment newInstance(int exercisePosition, int durationExercise) {
        Bundle args = new Bundle();
        args.putInt(RANK_EXERCISE, exercisePosition);
        args.putInt(DURATION_EXERCISE, durationExercise);

        ExerciseSweepPickingFragment fragment = new ExerciseSweepPickingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.exercise_sweep_picking_fragment, container, false);

        ButterKnife.bind(this, rootView);
        ((ProgramActivity) getActivity()).getActivityComponent().inject(this);  // TODO : Possibility to externalize this ? BaseActivity ?

        exerciseSweepPickingPresenter.setExerciseSweepPickingView(this);
        exerciseSweepPickingPresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        rankExercise = getArguments().getInt(RANK_EXERCISE);
        int durationExercise = getArguments().getInt(DURATION_EXERCISE);

        exerciseSweepPickingDuration.setText(String.format(getActivity().getString(R.string.exercise_duration_text),
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

    @OnClick(R.id.exercise_sweep_picking_next_button)
    public void handleClickExerciseScaleNextButton() {
        exerciseSweepPickingPresenter.showNextExercise(rankExercise + 1);
    }
}

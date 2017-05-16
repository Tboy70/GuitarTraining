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
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExerciseBackForthPresenter;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseBackForthView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Thomas on 16/05/2017.
 */

public class ExerciseBackForthForthFragment extends Fragment implements ExerciseBackForthView {

    public static final String RANK_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBackForthForthFragment.RANK_EXERCISE";
    public static final String DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBackForthForthFragment.DURATION_EXERCISE";

    @Inject
    ExerciseBackForthPresenter exerciseBackForthPresenter;

    @BindView(R.id.exercise_back_forth_duration)
    TextView exerciseGoBackDuration;

    private int rankExercise;

    public static ExerciseBackForthForthFragment newInstance(int exercisePosition, int durationExercise) {
        Bundle args = new Bundle();
        args.putInt(RANK_EXERCISE, exercisePosition);
        args.putInt(DURATION_EXERCISE, durationExercise);

        ExerciseBackForthForthFragment fragment = new ExerciseBackForthForthFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.exercise_back_forth_fragment, container, false);

        ButterKnife.bind(this, rootView);
        ((ProgramActivity) getActivity()).getActivityComponent().inject(this);  // TODO : Possibility to externalize this ? BaseActivity ?

        exerciseBackForthPresenter.setExerciseBackForthView(this);
        exerciseBackForthPresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        rankExercise = getArguments().getInt(RANK_EXERCISE);
        int durationExercise = getArguments().getInt(DURATION_EXERCISE);

        exerciseGoBackDuration.setText(String.format(getActivity().getString(R.string.exercise_duration_text),
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

    @OnClick(R.id.exercise_back_forth_next_button)
    public void handleClickExerciseScaleNextButton() {
        exerciseBackForthPresenter.showNextExercise(rankExercise + 1);
    }
}

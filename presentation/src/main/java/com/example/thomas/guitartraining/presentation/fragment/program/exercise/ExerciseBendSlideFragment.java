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
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExerciseBendSlidePresenter;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseBendSlideView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Thomas on 16/05/2017.
 */

public class ExerciseBendSlideFragment extends Fragment implements ExerciseBendSlideView {

    public static final String RANK_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBendSlideFragment.RANK_EXERCISE";
    public static final String DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBendSlideFragment.DURATION_EXERCISE";

    @Inject
    ExerciseBendSlidePresenter exerciseBendSlidePresenter;

    @BindView(R.id.exercise_bend_slide_duration)
    TextView exerciseBendSlideDuration;

    private int rankExercise;

    public static ExerciseBendSlideFragment newInstance(int exercisePosition, int durationExercise) {

        Bundle args = new Bundle();
        args.putInt(RANK_EXERCISE, exercisePosition);
        args.putInt(DURATION_EXERCISE, durationExercise);

        ExerciseBendSlideFragment fragment = new ExerciseBendSlideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.exercise_bend_slide_fragment, container, false);

        ButterKnife.bind(this, rootView);
        ((ProgramActivity) getActivity()).getActivityComponent().inject(this);  // TODO : Possibility to externalize this ? BaseActivity ?

        exerciseBendSlidePresenter.setExerciseBendSlideView(this);
        exerciseBendSlidePresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        rankExercise = getArguments().getInt(RANK_EXERCISE);
        int durationExercise = getArguments().getInt(DURATION_EXERCISE);

        exerciseBendSlideDuration.setText(String.format(getActivity().getString(R.string.exercise_duration_text),
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

    @OnClick(R.id.exercise_bend_slide_next_button)
    public void handleClickExerciseScaleNextButton() {
        exerciseBendSlidePresenter.showNextExercise(rankExercise + 1);
    }
}

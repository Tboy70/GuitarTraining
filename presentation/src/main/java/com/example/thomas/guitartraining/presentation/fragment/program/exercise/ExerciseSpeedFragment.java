package com.example.thomas.guitartraining.presentation.fragment.program.exercise;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.component.fragment.DurationComponent;
import com.example.thomas.guitartraining.presentation.fragment.BaseFragment;
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExerciseSpeedPresenter;
import com.example.thomas.guitartraining.presentation.utils.DateTimeUtils;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseSpeedView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Speed exercise fragment.
 */
public class ExerciseSpeedFragment extends BaseFragment implements ExerciseSpeedView {

    private static final String RANK_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSpeedFragment.RANK_EXERCISE";
    private static final String DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSpeedFragment.DURATION_EXERCISE";

    @Inject
    ExerciseSpeedPresenter exerciseSpeedPresenter;

    @BindView(R.id.fragment_exercise_speed_duration)
    TextView exerciseSpeedDuration;

    @BindView(R.id.fragment_exercise_speed_duration_left)
    TextView exerciseSpeedDurationLeft;

    private DurationComponent durationComponent;

    private int rankExercise;

    // Exercise duration variables
    private int durationExercise;
    private long durationLeft = DateTimeUtils.DEFAULT_DURATION_LEFT;

    public static ExerciseSpeedFragment newInstance(int exercisePosition, int durationExercise) {
        Bundle args = new Bundle();
        args.putInt(RANK_EXERCISE, exercisePosition);
        args.putInt(DURATION_EXERCISE, durationExercise);

        ExerciseSpeedFragment fragment = new ExerciseSpeedFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise_speed, container, false);

        ButterKnife.bind(this, rootView);

        exerciseSpeedPresenter.setExerciseSpeedView(this);
        exerciseSpeedPresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        durationComponent = new DurationComponent();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rankExercise = getArguments().getInt(RANK_EXERCISE);
        durationExercise = getArguments().getInt(DURATION_EXERCISE);

        setDurationUI();
        setToolbar(getActivity().getString(R.string.toolbar_title_exercise_speed));

        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.program_activity_menu_toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.program_activity_toolbar_about_icon:
                exerciseSpeedPresenter.displayDescriptionExercise(getActivity(), getActivity().getString(R.string.dialog_speed_exercise_description));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setLeftDuration(long timeCountInMilliSeconds) {
        durationLeft = durationComponent.setDurationLeft(
                exerciseSpeedDurationLeft,
                getActivity().getString(R.string.generic_exercise_duration_left_text),
                timeCountInMilliSeconds);
    }

    @OnClick(R.id.fragment_exercise_speed_next_button)
    public void handleClickExerciseSpeedNextButton() {
        exerciseSpeedPresenter.showNextExercise(rankExercise + 1);
    }

    @OnClick(R.id.fragment_exercise_speed_button_start_exercise)
    public void handleClickExerciseSpeedStartExercise() {
        exerciseSpeedPresenter.launchTimer(getActivity(), durationLeft);
    }

    private void setDurationUI() {
        durationLeft = durationComponent.setDuration(
                durationExercise,
                durationLeft,
                exerciseSpeedDuration,
                getActivity().getString(R.string.generic_exercise_duration_text),
                exerciseSpeedDurationLeft,
                getActivity().getString(R.string.generic_exercise_duration_left_text));
    }

    private void setToolbar(String toolbarTitle) {
        exerciseSpeedPresenter.setToolbar(toolbarTitle);
    }
}

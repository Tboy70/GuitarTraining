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
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExercisePullOffHammerOnPresenter;
import com.example.thomas.guitartraining.presentation.utils.DateTimeUtils;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExercisePullOffHammerOnView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Pull off / Hammer on exercise fragment.
 */
public class ExercisePullOffHammerOnFragment extends BaseFragment implements ExercisePullOffHammerOnView {

    private static final String RANK_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePullOffHammerOnFragment.RANK_EXERCISE";
    private static final String DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePullOffHammerOnFragment.DURATION_EXERCISE";

    @Inject
    ExercisePullOffHammerOnPresenter exercisePullOffHammerOnPresenter;

    @BindView(R.id.fragment_exercise_pull_off_hammer_on_duration)
    TextView exercisePullOffHammerOnDuration;

    @BindView(R.id.fragment_exercise_pull_off_hammer_on_duration_left)
    TextView exercisePullOffHammerOnDurationLeft;

    private DurationComponent durationComponent;

    private int rankExercise;

    // Exercise duration variables
    private int durationExercise;
    private long durationLeft = DateTimeUtils.DEFAULT_DURATION_LEFT;

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
        View rootView = inflater.inflate(R.layout.fragment_exercise_pull_off_hammer_on, container, false);

        ButterKnife.bind(this, rootView);

        exercisePullOffHammerOnPresenter.setExercisePullOffHammerOnView(this);
        exercisePullOffHammerOnPresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        durationComponent = new DurationComponent();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rankExercise = getArguments().getInt(RANK_EXERCISE);
        durationExercise = getArguments().getInt(DURATION_EXERCISE);

        setDurationUI();
        setToolbar(getActivity().getString(R.string.toolbar_title_exercise_pull_off_hammer_on));

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
                exercisePullOffHammerOnPresenter.displayDescriptionExercise(getActivity(), getActivity().getString(R.string.dialog_pull_off_hammer_on_exercise_description));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setLeftDuration(long timeCountInMilliSeconds) {
        durationLeft = durationComponent.setDurationLeft(
                exercisePullOffHammerOnDurationLeft,
                getActivity().getString(R.string.generic_exercise_duration_left_text),
                timeCountInMilliSeconds);
    }

    @OnClick(R.id.fragment_exercise_pull_off_hammer_on_next_button)
    public void handleClickExercisePullOffHammerOnNextButton() {
        exercisePullOffHammerOnPresenter.showNextExercise(rankExercise + 1);
    }

    @OnClick(R.id.fragment_exercise_pull_off_hammer_on_start_exercise)
    public void handleClickExercisePullOffHammerOnStartExercise() {
        exercisePullOffHammerOnPresenter.launchTimer(getActivity(), durationLeft);
    }

    private void setDurationUI() {
        durationLeft = durationComponent.setDuration(
                durationExercise,
                durationLeft,
                exercisePullOffHammerOnDuration,
                getActivity().getString(R.string.generic_exercise_duration_text),
                exercisePullOffHammerOnDurationLeft,
                getActivity().getString(R.string.generic_exercise_duration_left_text));
    }

    private void setToolbar(String toolbarTitle) {
        exercisePullOffHammerOnPresenter.setToolbar(toolbarTitle);
    }
}

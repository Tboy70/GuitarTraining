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
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExerciseSkipStringPresenter;
import com.example.thomas.guitartraining.presentation.utils.DateTimeUtils;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseSkipStringView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Skip string exercise fragment.
 */
public class ExerciseSkipStringFragment extends BaseFragment implements ExerciseSkipStringView {

    private static final String RANK_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSkipStringFragment.RANK_EXERCISE";
    private static final String DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSkipStringFragment.DURATION_EXERCISE";

    @Inject
    ExerciseSkipStringPresenter exerciseSkipStringPresenter;

    @BindView(R.id.fragment_exercise_skip_string_duration)
    TextView exerciseSkipStringDuration;

    @BindView(R.id.fragment_exercise_skip_string_duration_left)
    TextView exerciseSkipStringDurationLeft;

    private DurationComponent durationComponent;

    private int rankExercise;

    // Exercise duration variables
    private int durationExercise;
    private long durationLeft = DateTimeUtils.DEFAULT_DURATION_LEFT;

    public static ExerciseSkipStringFragment newInstance(int exercisePosition, int durationExercise) {
        Bundle args = new Bundle();
        args.putInt(RANK_EXERCISE, exercisePosition);
        args.putInt(DURATION_EXERCISE, durationExercise);

        ExerciseSkipStringFragment fragment = new ExerciseSkipStringFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise_skip_string, container, false);

        ButterKnife.bind(this, rootView);

        exerciseSkipStringPresenter.setExerciseSkipStringView(this);
        exerciseSkipStringPresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        durationComponent = new DurationComponent();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rankExercise = getArguments().getInt(RANK_EXERCISE);
        durationExercise = getArguments().getInt(DURATION_EXERCISE);

        setDurationUI();
        setToolbar(getActivity().getString(R.string.toolbar_title_exercise_skip_string));

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
                exerciseSkipStringPresenter.displayDescriptionExercise(getActivity(), getActivity().getString(R.string.dialog_skip_fragment_exercise_description));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setLeftDuration(long timeCountInMilliSeconds) {
        durationLeft = durationComponent.setDurationLeft(
                exerciseSkipStringDurationLeft,
                getActivity().getString(R.string.generic_exercise_duration_left_text),
                timeCountInMilliSeconds);
    }

    @OnClick(R.id.fragment_exercise_skip_string_next_button)
    public void handleClickExerciseSkipStringNextButton() {
        exerciseSkipStringPresenter.showNextExercise(rankExercise + 1);
    }

    @OnClick(R.id.fragment_exercise_skip_string_button_start_exercise)
    public void handleClickExerciseSkipStringStartExercise() {
        exerciseSkipStringPresenter.launchTimer(getActivity(), durationLeft);
    }

    private void setDurationUI() {
        durationLeft = durationComponent.setDuration(
                durationExercise,
                durationLeft,
                exerciseSkipStringDuration,
                getActivity().getString(R.string.generic_exercise_duration_text),
                exerciseSkipStringDurationLeft,
                getActivity().getString(R.string.generic_exercise_duration_left_text));
    }

    private void setToolbar(String toolbarTitle) {
        exerciseSkipStringPresenter.setToolbar(toolbarTitle);
    }
}

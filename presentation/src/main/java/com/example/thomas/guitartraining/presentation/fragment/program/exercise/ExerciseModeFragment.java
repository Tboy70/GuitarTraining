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
import android.widget.Button;
import android.widget.TextView;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.component.fragment.DurationComponent;
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExerciseModePresenter;
import com.example.thomas.guitartraining.presentation.utils.DateTimeUtils;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseModeView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Mode exercise fragment.
 */
public class ExerciseModeFragment extends Fragment implements ExerciseModeView {

    private static final String RANK_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseModeFragment.RANK_EXERCISE";
    private static final String DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseModeFragment.DURATION_EXERCISE";

    @Inject
    ExerciseModePresenter exerciseModePresenter;

    @BindView(R.id.fragment_exercise_mode_duration)
    TextView exerciseModeDuration;

    @BindView(R.id.fragment_exercise_mode_duration_left)
    TextView exerciseModeDurationLeft;

    @BindView(R.id.fragment_exercise_mode_button_choice_mode)
    Button buttonChoiceMode;

    @BindView(R.id.fragment_exercise_mode_button_start_exercise)
    Button startExerciseButton;

    private DurationComponent durationComponent;

    private int rankExercise;

    // Exercise duration variable
    private int durationExercise;
    private long durationLeft = DateTimeUtils.DEFAULT_DURATION_LEFT;

    public static ExerciseModeFragment newInstance(int exercisePosition, int durationExercise) {
        Bundle args = new Bundle();
        args.putInt(RANK_EXERCISE, exercisePosition);
        args.putInt(DURATION_EXERCISE, durationExercise);

        ExerciseModeFragment fragment = new ExerciseModeFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise_mode, container, false);

        ButterKnife.bind(this, rootView);
        ((ProgramActivity) getActivity()).getActivityComponent().inject(this);

        exerciseModePresenter.setExerciseModeView(this);
        exerciseModePresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        durationComponent = new DurationComponent();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rankExercise = getArguments().getInt(RANK_EXERCISE);
        durationExercise = getArguments().getInt(DURATION_EXERCISE);

        setDurationUI();
        setToolbar(getActivity().getString(R.string.toolbar_title_exercise_mode));

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
                exerciseModePresenter.displayDescriptionExercise(getActivity(), getActivity().getString(R.string.dialog_mode_exercise_description));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void displaySelectedChoice(String selectedItem) {
        if (selectedItem != null && selectedItem.length() > 0) {
            buttonChoiceMode.setText(selectedItem);
        }
    }

    @Override
    public void setLeftDuration(long timeCountInMilliSeconds) {
        durationLeft = durationComponent.setDurationLeft(
                exerciseModeDurationLeft,
                getActivity().getString(R.string.generic_exercise_duration_left_text),
                timeCountInMilliSeconds);
    }

    @OnClick(R.id.fragment_exercise_mode_next_button)
    public void handleClickExerciseModeNextButton() {
        exerciseModePresenter.showNextExercise(rankExercise + 1);
    }

    @OnClick(R.id.fragment_exercise_mode_button_choice_mode)
    public void handleClickExerciseModeButtonChoiceMode() {
        exerciseModePresenter.showSimpleChoiceDialog();
    }

    @OnClick(R.id.fragment_exercise_mode_random_selection)
    public void handleClickExerciseModeRandomSelection() {
        exerciseModePresenter.randomModeSelection();
    }

    @OnClick(R.id.fragment_exercise_mode_button_start_exercise)
    public void handleClickExerciseModeButtonStartExercise() {
        exerciseModePresenter.launchTimer(getActivity(), durationLeft);
    }

    private void setDurationUI() {
        durationLeft = durationComponent.setDuration(
                durationExercise,
                durationLeft,
                exerciseModeDuration,
                getActivity().getString(R.string.generic_exercise_duration_text),
                exerciseModeDurationLeft,
                getActivity().getString(R.string.generic_exercise_duration_left_text));
    }

    private void setToolbar(String toolbarTitle) {
        exerciseModePresenter.setToolbar(toolbarTitle);
    }
}

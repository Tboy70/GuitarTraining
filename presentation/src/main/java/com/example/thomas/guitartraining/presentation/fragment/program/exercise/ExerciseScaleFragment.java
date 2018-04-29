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
import com.example.thomas.guitartraining.presentation.fragment.BaseFragment;
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExerciseScalePresenter;
import com.example.thomas.guitartraining.presentation.utils.DateTimeUtils;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseScaleView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Scale exercise fragment.
 */
public class ExerciseScaleFragment extends BaseFragment implements ExerciseScaleView {

    private static final String RANK_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseScaleFragment.RANK_EXERCISE";
    private static final String DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseScaleFragment.DURATION_EXERCISE";

    public static final int SCALE_NOTE_SELECTION = 1;
    public static final int SCALE_MODE_SELECTION = 2;

    @Inject
    ExerciseScalePresenter exerciseScalePresenter;

    @BindView(R.id.fragment_exercise_scale_duration)
    TextView exerciseScaleDuration;

    @BindView(R.id.fragment_exercise_scale_duration_left)
    TextView exerciseScaleDurationLeft;

    @BindView(R.id.fragment_exercise_scale_button_choice_note)
    Button buttonChoiceNote;

    @BindView(R.id.fragment_exercise_scale_button_choice_mode)
    Button buttonChoiceTone;

    private DurationComponent durationComponent;

    private int rankExercise;

    // Exercise duration variables
    private int durationExercise;
    private long durationLeft = DateTimeUtils.DEFAULT_DURATION_LEFT;

    public static ExerciseScaleFragment newInstance(int exercisePosition, int durationExercise) {
        Bundle args = new Bundle();
        args.putInt(RANK_EXERCISE, exercisePosition);
        args.putInt(DURATION_EXERCISE, durationExercise);

        ExerciseScaleFragment fragment = new ExerciseScaleFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise_scale, container, false);

        ButterKnife.bind(this, rootView);

        exerciseScalePresenter.setExerciseScaleView(this);
        exerciseScalePresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        durationComponent = new DurationComponent();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rankExercise = getArguments().getInt(RANK_EXERCISE);
        durationExercise = getArguments().getInt(DURATION_EXERCISE);

        setDurationUI();
        setToolbar(getActivity().getString(R.string.toolbar_title_exercise_scale));

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
                exerciseScalePresenter.displayDescriptionExercise(getActivity(), getActivity().getString(R.string.dialog_scale_exercise_description));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void displaySelectedChoice(String selectedItem, int listTypeSelection) {
        if (selectedItem != null && selectedItem.length() > 0) {
            switch (listTypeSelection) {
                case SCALE_NOTE_SELECTION:
                    buttonChoiceNote.setText(selectedItem);
                    break;
                case SCALE_MODE_SELECTION:
                    buttonChoiceTone.setText(selectedItem);
                    break;
            }
        }
    }

    @Override
    public void setLeftDuration(long timeCountInMilliSeconds) {
        durationLeft = durationComponent.setDurationLeft(
                exerciseScaleDurationLeft,
                getActivity().getString(R.string.generic_exercise_duration_left_text),
                timeCountInMilliSeconds);
    }

    @OnClick(R.id.fragment_exercise_scale_next_button)
    public void handleClickExerciseScaleNextButton() {
        exerciseScalePresenter.showNextExercise(rankExercise + 1);
    }

    @OnClick(R.id.fragment_exercise_scale_button_choice_note)
    public void handleClickExerciseScaleButtonChoiceNote() {
        exerciseScalePresenter.showSimpleChoiceDialog(SCALE_NOTE_SELECTION);
    }

    @OnClick(R.id.fragment_exercise_scale_button_choice_mode)
    public void handleClickExerciseScaleButtonChoiceMode() {
        exerciseScalePresenter.showSimpleChoiceDialog(SCALE_MODE_SELECTION);
    }

    @OnClick(R.id.fragment_exercise_scale_random_selection)
    public void handleClickExerciseScaleRandomSelection() {
        exerciseScalePresenter.randomScaleSelection();
    }

    @OnClick(R.id.fragment_exercise_scale_button_start_exercise)
    public void handleClickExerciseScaleStartExercise() {
        exerciseScalePresenter.launchTimer(getActivity(), durationLeft);
    }

    private void setDurationUI() {
        durationLeft = durationComponent.setDuration(
                durationExercise,
                durationLeft,
                exerciseScaleDuration,
                getActivity().getString(R.string.generic_exercise_duration_text),
                exerciseScaleDurationLeft,
                getActivity().getString(R.string.generic_exercise_duration_left_text));
    }

    private void setToolbar(String toolbarTitle) {
        exerciseScalePresenter.setToolbar(toolbarTitle);
    }
}

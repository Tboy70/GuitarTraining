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
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExerciseSweepPickingPresenter;
import com.example.thomas.guitartraining.presentation.utils.DateTimeUtils;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseSweepPickingView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Sweep picking exercise fragment.
 */
public class ExerciseSweepPickingFragment extends Fragment implements ExerciseSweepPickingView {

    private static final String RANK_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSweepPickingFragment.RANK_EXERCISE";
    private static final String DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSweepPickingFragment.DURATION_EXERCISE";

    @Inject
    ExerciseSweepPickingPresenter exerciseSweepPickingPresenter;

    @BindView(R.id.exercise_sweep_picking_duration)
    TextView exerciseSweepPickingDuration;

    @BindView(R.id.exercise_sweep_picking_duration_left)
    TextView exerciseSweepPickingDurationLeft;

    private DurationComponent durationComponent;

    private int rankExercise;

    // Exercise duration variables
    private int durationExercise;
    private long durationLeft = DateTimeUtils.DEFAULT_DURATION_LEFT;

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
        ((ProgramActivity) getActivity()).getActivityComponent().inject(this);

        exerciseSweepPickingPresenter.setExerciseSweepPickingView(this);
        exerciseSweepPickingPresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        durationComponent = new DurationComponent();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rankExercise = getArguments().getInt(RANK_EXERCISE);
        durationExercise = getArguments().getInt(DURATION_EXERCISE);

        setDurationUI();
        setToolbar(getActivity().getString(R.string.toolbar_title_exercise_sweep_picking));

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
                exerciseSweepPickingPresenter.displayDescriptionExercise(getActivity(), getActivity().getString(R.string.dialog_description_sweep_picking_exercise));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setLeftDuration(long timeCountInMilliSeconds) {
        durationLeft = durationComponent.setDurationLeft(
                exerciseSweepPickingDurationLeft,
                getActivity().getString(R.string.exercise_duration_text_left),
                timeCountInMilliSeconds);
    }

    @OnClick(R.id.exercise_sweep_picking_next_button)
    public void handleClickExerciseScaleNextButton() {
        exerciseSweepPickingPresenter.showNextExercise(rankExercise + 1);
    }

    @OnClick(R.id.exercise_sweep_picking_button_start_exercise)
    public void handleClickExerciseScaleStartExercise() {
        exerciseSweepPickingPresenter.launchTimer(getActivity(), durationLeft);
    }

    private void setDurationUI() {
        durationLeft = durationComponent.setDuration(
                durationExercise,
                durationLeft,
                exerciseSweepPickingDuration,
                getActivity().getString(R.string.exercise_duration_text),
                exerciseSweepPickingDurationLeft,
                getActivity().getString(R.string.exercise_duration_text_left));
    }

    private void setToolbar(String toolbarTitle) {
        exerciseSweepPickingPresenter.setToolbar(toolbarTitle);
    }
}

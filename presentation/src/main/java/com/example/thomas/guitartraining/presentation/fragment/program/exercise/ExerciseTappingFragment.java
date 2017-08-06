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
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.ExerciseTappingPresenter;
import com.example.thomas.guitartraining.presentation.utils.DateTimeUtils;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.exercise.ExerciseTappingView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Tapping exercise fragment.
 */
public class ExerciseTappingFragment extends Fragment implements ExerciseTappingView {

    private static final String RANK_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseTappingFragment.RANK_EXERCISE";
    private static final String DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseTappingFragment.DURATION_EXERCISE";

    @Inject
    ExerciseTappingPresenter exerciseTappingPresenter;

    @BindView(R.id.exercise_tapping_duration)
    TextView exerciseTappingDuration;

    @BindView(R.id.exercise_tapping_duration_left)
    TextView exerciseTappingDurationLeft;

    private DurationComponent durationComponent;

    private int rankExercise;

    // Exercise duration variables
    private int durationExercise;
    private long durationLeft = DateTimeUtils.DEFAULT_DURATION_LEFT;

    public static ExerciseTappingFragment newInstance(int exercisePosition, int durationExercise) {

        Bundle args = new Bundle();

        args.putInt(RANK_EXERCISE, exercisePosition);
        args.putInt(DURATION_EXERCISE, durationExercise);

        ExerciseTappingFragment fragment = new ExerciseTappingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.exercise_tapping_fragment, container, false);

        ButterKnife.bind(this, rootView);
        ((ProgramActivity) getActivity()).getActivityComponent().inject(this);

        exerciseTappingPresenter.setExerciseTappingView(this);
        exerciseTappingPresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        durationComponent = new DurationComponent();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rankExercise = getArguments().getInt(RANK_EXERCISE);
        durationExercise = getArguments().getInt(DURATION_EXERCISE);

        setDurationUI();
        setToolbar(getActivity().getString(R.string.toolbar_title_exercise_tapping));

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
                exerciseTappingPresenter.displayDescriptionExercise(getActivity(), getActivity().getString(R.string.dialog_description_tapping_exercise));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setLeftDuration(long timeCountInMilliSeconds) {
        durationLeft = durationComponent.setDurationLeft(
                exerciseTappingDurationLeft,
                getActivity().getString(R.string.exercise_duration_text_left),
                timeCountInMilliSeconds);
    }

    @OnClick(R.id.exercise_tapping_next_button)
    public void handleClickExerciseTappingNextButton() {
        exerciseTappingPresenter.showNextExercise(rankExercise + 1);
    }

    @OnClick(R.id.exercise_tapping_button_start_exercise)
    public void handleClickExerciseTappingStartExercise() {
        exerciseTappingPresenter.launchTimer(getActivity(), durationLeft);
    }

    private void setDurationUI() {
        durationLeft = durationComponent.setDuration(
                durationExercise,
                durationLeft,
                exerciseTappingDuration,
                getActivity().getString(R.string.exercise_duration_text),
                exerciseTappingDurationLeft,
                getActivity().getString(R.string.exercise_duration_text_left));
    }

    private void setToolbar(String toolbarTitle) {
        exerciseTappingPresenter.setToolbar(toolbarTitle);
    }
}

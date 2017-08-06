package com.example.thomas.guitartraining.presentation.fragment.ui;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.listener.OnTimerDialogDismiss;
import com.example.thomas.guitartraining.presentation.utils.DateTimeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Timer dialog fragment for exercises.
 */
public class TimerDialogFragment extends DialogFragment {

    @BindView(R.id.progress_bar_timer)
    ProgressBar progressBarCircle;

    @BindView(R.id.text_view_timer)
    TextView textViewTime;

    @BindView(R.id.button_start_timer)
    Button startPauseButton;

    private static final int MILLISECONDS = 1000;

    private OnTimerDialogDismiss timerDialogDismissListener;

    private enum TimerStatus {
        STARTED,
        STOPPED
    }

    private TimerStatus timerStatus = TimerStatus.STOPPED;

    private long timeCountInMilliSeconds;
    private long timeLeftToTheEndOfTimer;

    private CountDownTimer countDownTimer;

    private String dialogTitle;
    private long durationExercise;

    private static final String DIALOG_FRAGMENT_TITLE = "com.example.thomas.guitartraining.presentation.fragment.ui.TestDialogFragment.DIALOG_FRAGMENT_TITLE";
    private static final String DIALOG_FRAGMENT_DURATION_EXERCISE = "com.example.thomas.guitartraining.presentation.fragment.ui.TestDialogFragment.DIALOG_FRAGMENT_DURATION_EXERCISE";

    public static TimerDialogFragment newInstance(String dialogTitle, long durationExercise) {

        Bundle args = new Bundle();

        args.putString(DIALOG_FRAGMENT_TITLE, dialogTitle);
        args.putLong(DIALOG_FRAGMENT_DURATION_EXERCISE, durationExercise);

        TimerDialogFragment fragment = new TimerDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.timer_dialog_layout, container, false);

        ButterKnife.bind(this, rootView);
        ((ProgramActivity) getActivity()).getActivityComponent().inject(this);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            dialogTitle = args.getString(DIALOG_FRAGMENT_TITLE);
            durationExercise = args.getLong(DIALOG_FRAGMENT_DURATION_EXERCISE);
            timeLeftToTheEndOfTimer = durationExercise;
        }

        textViewTime.setText(DateTimeUtils.convertMillisecondsToTimeFormat(durationExercise));

        getDialog().setCanceledOnTouchOutside(true);
        getDialog().setTitle(dialogTitle);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        timerDialogDismissListener.onDismiss(timeLeftToTheEndOfTimer);
    }

    @OnClick(R.id.button_start_timer)
    public void handleClickButtonStartTimer() {
        startAndPauseTimer();
    }

    public void setTimerDialogDismissListener(OnTimerDialogDismiss timerDialogDismissListener) {
        this.timerDialogDismissListener = timerDialogDismissListener;
    }

    private void startAndPauseTimer() {
        if (timerStatus == TimerStatus.STOPPED) {
            initializeTimeValue(durationExercise);
            initializeProgressBar();
            timerStatus = TimerStatus.STARTED;
            startPauseButton.setText(getActivity().getString(R.string.timer_pause_button));
            startTimer();
        } else {
            timerStatus = TimerStatus.STOPPED;
            startPauseButton.setText(getActivity().getString(R.string.timer_start_button));
            pauseTimer();
        }
    }

    private void initializeTimeValue(long durationExercise) {
        timeCountInMilliSeconds = durationExercise;
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, MILLISECONDS) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTime.setText(DateTimeUtils.convertMillisecondsToTimeFormat(millisUntilFinished));
                progressBarCircle.setProgress((int) (millisUntilFinished / MILLISECONDS));
                timeLeftToTheEndOfTimer = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                textViewTime.setText(DateTimeUtils.convertMillisecondsToTimeFormat(timeCountInMilliSeconds));
                initializeProgressBar();
                timerStatus = TimerStatus.STOPPED;
            }
        }.start();
        countDownTimer.start();
    }

    private void pauseTimer() {
        countDownTimer.cancel();
    }

    private void initializeProgressBar() {
        progressBarCircle.setMax((int) timeCountInMilliSeconds / MILLISECONDS);
        progressBarCircle.setProgress((int) timeCountInMilliSeconds / MILLISECONDS);
    }
}

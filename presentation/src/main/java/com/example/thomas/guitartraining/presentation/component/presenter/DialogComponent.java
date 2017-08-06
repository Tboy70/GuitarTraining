package com.example.thomas.guitartraining.presentation.component.presenter;

import android.app.Activity;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.fragment.ui.TimerDialogFragment;
import com.example.thomas.guitartraining.presentation.presenter.program.exercise.listener.OnTimerDialogDismiss;
import com.example.thomas.guitartraining.presentation.utils.ConstantTag;

import javax.inject.Inject;

@PerActivity
public class DialogComponent {

    @Inject
    public DialogComponent() {

    }

    public void showTimerDialog(Activity activity, long durationExercise, OnTimerDialogDismiss onTimerDialogDismiss) {
        TimerDialogFragment timerDialogFragment = TimerDialogFragment.newInstance(activity.getString(R.string.timer_title), durationExercise);
        timerDialogFragment.setTimerDialogDismissListener(onTimerDialogDismiss);
        timerDialogFragment.show(activity.getFragmentManager(), ConstantTag.DIALOG.toString());
    }
}

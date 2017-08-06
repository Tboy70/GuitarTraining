package com.example.thomas.guitartraining.di.component;

import android.app.Activity;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.di.module.ActivityModule;
import com.example.thomas.guitartraining.presentation.activity.MainActivity;
import com.example.thomas.guitartraining.presentation.activity.OfflineActivity;
import com.example.thomas.guitartraining.presentation.activity.OnlineActivity;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.activity.StartActivity;
import com.example.thomas.guitartraining.presentation.fragment.navigation.AuthenticationChoiceFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.LoginFragment;
import com.example.thomas.guitartraining.presentation.fragment.offline.OfflineProgramChoiceFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramsFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.UserSongsFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.EndProgramFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.IntroProgramFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBackForthFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBendSlideFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseModeFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePalmMuteFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePullOffHammerOnFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseScaleFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSkipStringFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSpeedFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSweepPickingFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseTappingFragment;
import com.example.thomas.guitartraining.presentation.fragment.ui.TimerDialogFragment;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

import dagger.Component;

/**
 * ActivityComponent interface for Dependency Injection with Dagger.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graph
    Activity activity();

    BaseNavigatorListener baseNavigatorListener();

    void inject(StartActivity startActivity);

    void inject(OnlineActivity onlineActivity);

    void inject(OfflineActivity offlineActivity);

    void inject(ProgramActivity programActivity);

    void inject(MainActivity mainActivity);

    void inject(AuthenticationChoiceFragment authenticationChoiceFragment);

    void inject(OfflineProgramChoiceFragment offlineProgramChoiceFragment);

    void inject(IntroProgramFragment introProgramFragment);

    void inject(ExerciseScaleFragment exerciseScaleFragment);

    void inject(ExerciseModeFragment exerciseModeFragment);

    void inject(ExercisePullOffHammerOnFragment exercisePullOffHammerOnFragment);

    void inject(ExerciseBendSlideFragment exerciseBendSlideFragment);

    void inject(ExerciseBackForthFragment exerciseBackForthFragment);

    void inject(ExercisePalmMuteFragment exercisePalmMuteFragment);

    void inject(ExerciseSkipStringFragment exerciseSkipStringFragment);

    void inject(ExerciseTappingFragment exerciseTappingFragment);

    void inject(ExerciseSweepPickingFragment exerciseSweepPickingFragment);

    void inject(ExerciseSpeedFragment exerciseSpeedFragment);

    void inject(EndProgramFragment endProgramFragment);

    void inject(TimerDialogFragment timerDialogFragment);

    void inject(LoginFragment loginFragment);

    void inject(UserProgramsFragment userProgramsFragment);

    void inject(UserSongsFragment userSongsFragment);
}

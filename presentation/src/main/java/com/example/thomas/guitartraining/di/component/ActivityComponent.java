package com.example.thomas.guitartraining.di.component;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.di.module.ActivityModule;
import com.example.thomas.guitartraining.presentation.activity.MainActivity;
import com.example.thomas.guitartraining.presentation.activity.OfflineActivity;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.fragment.AuthenticationChoiceFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.EndProgramFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseModeFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseScaleFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.IntroProgramFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.ListUsersFragment;
import com.example.thomas.guitartraining.presentation.fragment.OfflineProgramChoiceFragment;

import dagger.Component;

/**
 * ActivityComponent interface for Dependency Injection with Dagger.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(OfflineActivity offlineActivity);

    void inject(ProgramActivity programActivity);

    void inject(ListUsersFragment listUsersFragment);

    void inject(AuthenticationChoiceFragment authenticationChoiceFragment);

    void inject(OfflineProgramChoiceFragment offlineProgramChoiceFragment);

    void inject(IntroProgramFragment introProgramFragment);

    void inject(ExerciseScaleFragment exerciseScaleFragment);

    void inject(ExerciseModeFragment exerciseModeFragment);

    void inject(EndProgramFragment endProgramFragment);
}

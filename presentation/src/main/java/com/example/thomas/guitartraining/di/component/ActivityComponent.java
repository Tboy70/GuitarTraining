package com.example.thomas.guitartraining.di.component;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.di.module.ActivityModule;
import com.example.thomas.guitartraining.presentation.activity.MainActivity;
import com.example.thomas.guitartraining.presentation.activity.OfflineActivity;
import com.example.thomas.guitartraining.presentation.fragment.AuthentificationChoiceFragment;
import com.example.thomas.guitartraining.presentation.fragment.ListUsersFragment;
import com.example.thomas.guitartraining.presentation.fragment.OfflineProgramChoiceFragment;
import com.example.thomas.guitartraining.presentation.fragment.OfflineTheoreticalProgramFragment;

import dagger.Component;

/**
 * ActivityComponent interface for Dependency Injection with Dagger.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void inject(OfflineActivity offlineActivity);

    void inject(ListUsersFragment listUsersFragment);
    void inject(AuthentificationChoiceFragment authentificationChoiceFragment);
    void inject(OfflineProgramChoiceFragment offlineProgramChoiceFragment);
    void inject(OfflineTheoreticalProgramFragment offlineTheoreticalProgramFragment);
}

package com.example.thomas.guitartraining.di.module;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.di.module.activity.LoginActivityModule;
import com.example.thomas.guitartraining.di.module.activity.NotConnectedActivityModule;
import com.example.thomas.guitartraining.di.module.activity.ProgramActivityModule;
import com.example.thomas.guitartraining.di.module.activity.StartActivityModule;
import com.example.thomas.guitartraining.di.module.activity.UserPanelActivityModule;
import com.example.thomas.guitartraining.di.module.activity.UserProgramActivityModule;
import com.example.thomas.guitartraining.presentation.activity.LoginActivity;
import com.example.thomas.guitartraining.presentation.activity.NotConnectedActivity;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.activity.StartActivity;
import com.example.thomas.guitartraining.presentation.activity.UserPanelActivity;
import com.example.thomas.guitartraining.presentation.activity.UserProgramActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityInjectorModule {

    @PerActivity
    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity loginActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = NotConnectedActivityModule.class)
    abstract NotConnectedActivity notConnectedActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = ProgramActivityModule.class)
    abstract ProgramActivity programActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = StartActivityModule.class)
    abstract StartActivity startActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = UserPanelActivityModule.class)
    abstract UserPanelActivity userPanelActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = UserProgramActivityModule.class)
    abstract UserProgramActivity userProgramActivityInjector();
}

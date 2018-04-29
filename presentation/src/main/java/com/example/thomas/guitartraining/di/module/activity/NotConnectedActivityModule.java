package com.example.thomas.guitartraining.di.module.activity;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.di.PerFragment;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.activity.NotConnectedActivity;
import com.example.thomas.guitartraining.presentation.fragment.offline.NotConnectedProgramChoiceFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = BaseActivityModule.class)
public abstract class NotConnectedActivityModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract NotConnectedProgramChoiceFragment notConnectedProgramChoiceFragmentInjector();

    @PerActivity
    @Binds
    abstract BaseActivity bindBaseActivity(NotConnectedActivity notConnectedActivity);
}

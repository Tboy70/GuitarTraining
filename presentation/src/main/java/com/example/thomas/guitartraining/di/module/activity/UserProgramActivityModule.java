package com.example.thomas.guitartraining.di.module.activity;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.di.PerFragment;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.activity.UserProgramActivity;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramCreationFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramDetailsFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = BaseActivityModule.class)
public abstract class UserProgramActivityModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract UserProgramDetailsFragment userProgramDetailsFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract UserProgramCreationFragment userProgramCreationFragmentInjector();

    @PerActivity
    @Binds
    abstract BaseActivity bindBaseActivity(UserProgramActivity userProgramActivity);
}

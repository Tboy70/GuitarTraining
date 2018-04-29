package com.example.thomas.guitartraining.di.module.activity;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.di.PerFragment;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.activity.UserPanelActivity;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramsListFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.UserSongsFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = BaseActivityModule.class)
public abstract class UserPanelActivityModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract UserProgramsListFragment userProgramsListFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract UserSongsFragment userSongsFragmentInjector();

    @PerActivity
    @Binds
    abstract BaseActivity bindBaseActivity(UserPanelActivity userPanelActivity);
}

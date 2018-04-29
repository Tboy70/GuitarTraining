package com.example.thomas.guitartraining.di.module.activity;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.di.PerFragment;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.activity.LoginActivity;
import com.example.thomas.guitartraining.presentation.fragment.user.ConnectionFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = BaseActivityModule.class)
public abstract class LoginActivityModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract ConnectionFragment connectionFragmentInjector();

    @PerActivity
    @Binds
    abstract BaseActivity bindBaseActivity(LoginActivity loginActivity);
}

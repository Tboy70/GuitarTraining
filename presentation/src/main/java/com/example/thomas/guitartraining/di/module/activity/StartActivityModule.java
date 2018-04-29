package com.example.thomas.guitartraining.di.module.activity;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.di.PerFragment;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.activity.StartActivity;
import com.example.thomas.guitartraining.presentation.fragment.navigation.AuthenticationChoiceFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.UserSongsFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = BaseActivityModule.class)
public abstract class StartActivityModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract AuthenticationChoiceFragment authenticationChoiceFragmentInjector();

    @PerActivity
    @Binds
    abstract BaseActivity bindBaseActivity(StartActivity startActivity);
}

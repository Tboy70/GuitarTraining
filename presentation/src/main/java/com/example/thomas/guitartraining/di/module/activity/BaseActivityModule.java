package com.example.thomas.guitartraining.di.module.activity;

import android.support.v4.app.FragmentManager;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseActivityModule {

    @PerActivity
    @Provides
    FragmentManager provideSupportFragmentManager(BaseActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @PerActivity
    @Provides
    BaseNavigatorListener provideBaseNavigatorListener(BaseActivity activity) {
        return (BaseNavigatorListener)activity;
    }

}

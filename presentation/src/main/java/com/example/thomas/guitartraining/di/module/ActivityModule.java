package com.example.thomas.guitartraining.di.module;

import android.app.Activity;

import com.example.thomas.guitartraining.presentation.navigator.BaseNavigatorListener;

import dagger.Module;
import dagger.Provides;

/**
 * ActivityModule class for the Dependency Injection with Dagger.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity activity() {
        return this.activity;
    }

    @Provides
    BaseNavigatorListener provideBaseNavigatorListener() {
        return (BaseNavigatorListener) activity;
    }
}

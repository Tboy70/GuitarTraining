package com.example.thomas.guitartraining.di.module;

import android.app.Activity;

import com.example.thomas.guitartraining.presentation.view.MainNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.OfflineNavigatorListener;

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
    MainNavigatorListener provideMainNavigatorListener() {
        return (MainNavigatorListener) activity;
    }

    @Provides
    OfflineNavigatorListener offlineNavigatorListener() {
        return (OfflineNavigatorListener) activity;
    }
}

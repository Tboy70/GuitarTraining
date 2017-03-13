package com.example.thomas.guitartraining.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Thomas on 11/03/2017.
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
}

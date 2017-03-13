package com.example.thomas.guitartraining.di.module;

import android.content.Context;

import com.example.thomas.guitartraining.GuitarTrainingApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Thomas on 11/03/2017.
 */

@Module
public class ApplicationModule {
    private final GuitarTrainingApplication application;

    public ApplicationModule(GuitarTrainingApplication application) {
        this.application = application;
    }

    @Provides
    Context provideApplicationContext() {
        return this.application;
    }
}

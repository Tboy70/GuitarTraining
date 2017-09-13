package com.example.thomas.guitartraining;

import android.app.Application;

import com.example.thomas.guitartraining.di.component.ApplicationComponent;
import com.example.thomas.guitartraining.di.component.DaggerApplicationComponent;
import com.example.thomas.guitartraining.di.module.ApplicationModule;

/**
 * Application class.
 */
public class GuitarTrainingApplication extends Application {

    private static GuitarTrainingApplication application;
    private ApplicationComponent applicationComponent;

    public static GuitarTrainingApplication application() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        initializeInjector();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }
}

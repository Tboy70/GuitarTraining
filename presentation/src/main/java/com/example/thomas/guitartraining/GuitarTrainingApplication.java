package com.example.thomas.guitartraining;

import android.app.Application;

import com.example.thomas.guitartraining.di.component.ApplicationComponent;
import com.example.thomas.guitartraining.di.component.DaggerApplicationComponent;
import com.example.thomas.guitartraining.di.module.ApplicationModule;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

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
        FlowManager.init(new FlowConfig.Builder(this).build());
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }
}

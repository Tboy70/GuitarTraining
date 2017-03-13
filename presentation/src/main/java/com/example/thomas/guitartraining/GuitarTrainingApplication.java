package com.example.thomas.guitartraining;

import android.app.Application;

import com.example.thomas.guitartraining.di.component.ApplicationComponent;
import com.example.thomas.guitartraining.di.component.DaggerApplicationComponent;
import com.example.thomas.guitartraining.di.module.ApplicationModule;
import com.example.thomas.guitartraining.presentation.navigator.MainNavigator;

/**
 * Created by Thomas on 11/03/2017.
 */

public class GuitarTrainingApplication extends Application {

    public static GuitarTrainingApplication application;
    private ApplicationComponent applicationComponent;
    private MainNavigator mainNavigator;

    @Override
    public void onCreate() {
        super.onCreate();
        injectParameters();
        application = this;
        initializeInjector();
    }

    private void injectParameters() {
        mainNavigator = new MainNavigator();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static GuitarTrainingApplication application() {
        return application;
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}

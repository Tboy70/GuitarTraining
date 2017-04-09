package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.thomas.guitartraining.GuitarTrainingApplication;
import com.example.thomas.guitartraining.di.component.ActivityComponent;
import com.example.thomas.guitartraining.di.component.ApplicationComponent;
import com.example.thomas.guitartraining.di.component.DaggerActivityComponent;
import com.example.thomas.guitartraining.di.module.ActivityModule;

/**
 * Base activity of the application.
 * Useful for dagger injection.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initializeInjector();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    protected ApplicationComponent getApplicationComponent() {
        GuitarTrainingApplication app = GuitarTrainingApplication.application();
        return app.getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    private void initializeInjector() {
        this.activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }
}
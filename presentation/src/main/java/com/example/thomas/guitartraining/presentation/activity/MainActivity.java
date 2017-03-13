package com.example.thomas.guitartraining.presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.thomas.guitartraining.GuitarTrainingApplication;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.component.ActivityComponent;
import com.example.thomas.guitartraining.di.component.ApplicationComponent;
import com.example.thomas.guitartraining.di.component.DaggerActivityComponent;
import com.example.thomas.guitartraining.di.module.ActivityModule;
import com.example.thomas.guitartraining.presentation.navigator.MainNavigator;
import com.example.thomas.guitartraining.presentation.view.MainNavigatorListener;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainNavigatorListener {

    private ActivityComponent activityComponent;
    private MainNavigator mainNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        injectParameters();
        this.initializeInjector();
        setContentView(R.layout.activity_main);
    }

    private void injectParameters() {
        mainNavigator = new MainNavigator();
    }

    private void initializeInjector() {
        this.activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    private ApplicationComponent getApplicationComponent() {
        GuitarTrainingApplication app = GuitarTrainingApplication.application();
        return app.getApplicationComponent();
    }

    private ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    protected void onStart() {
        super.onStart();

        loadListUsers();
    }

    public void loadListUsers() {
        mainNavigator.loadListUsers(this);
    }
}

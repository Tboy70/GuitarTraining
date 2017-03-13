package com.example.thomas.guitartraining;

import android.app.Application;

/**
 * Created by Thomas on 11/03/2017.
 */

public class GuitarTrainingApplication extends Application {

    public static GuitarTrainingApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static GuitarTrainingApplication application() {
        return application;
    }
}

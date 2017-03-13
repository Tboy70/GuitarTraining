package com.example.thomas.guitartraining.di.component;

import android.content.Context;

import com.example.thomas.guitartraining.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Thomas on 11/03/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context context();
}

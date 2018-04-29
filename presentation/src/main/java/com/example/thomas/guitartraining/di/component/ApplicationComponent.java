package com.example.thomas.guitartraining.di.component;

import android.app.Application;

import com.example.thomas.guitartraining.GuitarTrainingApplication;
import com.example.thomas.guitartraining.di.module.ActivityInjectorModule;
import com.example.thomas.guitartraining.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * ApplicationComponent interface for dependency injection with Dagger.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        AndroidSupportInjectionModule.class,
        ActivityInjectorModule.class})
public interface ApplicationComponent {

    void inject(GuitarTrainingApplication application);

    @Component.Builder
    abstract class Builder {

        @BindsInstance
        public abstract Builder application(Application application);

        public abstract ApplicationComponent build();
    }
}

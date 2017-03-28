package com.example.thomas.guitartraining.di.module;

import android.content.Context;

import com.example.data.executor.JobExecutor;
import com.example.data.repository.UserDataRepository;
import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.UserRepository;
import com.example.thomas.guitartraining.GuitarTrainingApplication;
import com.example.thomas.guitartraining.presentation.executor.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * ApplicationModule class for dependency injection with Dagger.
 */
@Module
public class ApplicationModule {
    private final GuitarTrainingApplication application;

    public ApplicationModule(GuitarTrainingApplication application) {
        this.application = application;
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

}

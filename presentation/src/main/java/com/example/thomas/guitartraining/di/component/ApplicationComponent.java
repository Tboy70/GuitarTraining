package com.example.thomas.guitartraining.di.component;

import android.content.Context;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.ProgramRepository;
import com.example.repository.UserRepository;
import com.example.thomas.guitartraining.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * ApplicationComponent interface for dependency injection with Dagger.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context context();

    UserRepository userRepository();

    ProgramRepository programRepository();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();
}

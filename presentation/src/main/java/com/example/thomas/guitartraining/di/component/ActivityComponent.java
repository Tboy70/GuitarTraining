package com.example.thomas.guitartraining.di.component;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.di.module.ActivityModule;
import com.example.thomas.guitartraining.presentation.fragment.ListUsersFragment;

import dagger.Component;

/**
 * Created by Thomas on 11/03/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(ListUsersFragment listUsersFragment);
}

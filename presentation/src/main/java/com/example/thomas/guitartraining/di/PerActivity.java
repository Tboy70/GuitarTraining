package com.example.thomas.guitartraining.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created scope named "PerActivity".
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}

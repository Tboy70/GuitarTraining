package com.example.thomas.guitartraining.di.module.activity;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.di.PerFragment;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.fragment.program.EndProgramFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBackForthFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseBendSlideFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseModeFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePalmMuteFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExercisePullOffHammerOnFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseScaleFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSkipStringFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSpeedFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseSweepPickingFragment;
import com.example.thomas.guitartraining.presentation.fragment.program.exercise.ExerciseTappingFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramCreationFragment;
import com.example.thomas.guitartraining.presentation.fragment.user.UserProgramDetailsFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = BaseActivityModule.class)
public abstract class ProgramActivityModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract ExerciseScaleFragment exerciseScaleFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract ExerciseModeFragment exerciseModeFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract ExercisePullOffHammerOnFragment exercisePullOffHammerOnFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract ExerciseBendSlideFragment exerciseBendSlideFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract ExerciseBackForthFragment exerciseBackForthFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract ExercisePalmMuteFragment exercisePalmMuteFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract ExerciseSkipStringFragment exerciseSkipStringFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract ExerciseTappingFragment exerciseTappingFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract ExerciseSweepPickingFragment exerciseSweepPickingFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract ExerciseSpeedFragment exerciseSpeedFragmentInjector();

    @PerFragment
    @ContributesAndroidInjector
    abstract EndProgramFragment endProgramFragmentInjector();

    @PerActivity
    @Binds
    abstract BaseActivity bindBaseActivity(ProgramActivity programActivity);

}

package com.example.thomas.guitartraining.presentation.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.navigator.OfflineNavigator;
import com.example.thomas.guitartraining.presentation.navigator.ProgramNavigator;
import com.example.thomas.guitartraining.presentation.presenter.OfflinePresenter;
import com.example.thomas.guitartraining.presentation.presenter.ProgramPresenter;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by amiltonedev_lt043 on 08/05/2017.
 */

public class ProgramActivity extends BaseActivity implements ProgramNavigatorListener {

    @Inject
    ProgramPresenter programPresenter;

    private ProgramNavigator programNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        injectParameters();
    }

    private void injectParameters() {
        programNavigator = new ProgramNavigator();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // TODO : Set toolbar.
    }
}

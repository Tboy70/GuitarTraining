package com.example.thomas.guitartraining.presentation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.listener.UserProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel.ProgramViewModel;
import com.example.thomas.guitartraining.presentation.navigator.UserProgramNavigator;
import com.example.thomas.guitartraining.presentation.presenter.user.UserProgramPresenter;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserProgramActivity extends BaseActivity implements UserProgramNavigatorListener, UserProgramView {

    @Inject
    UserProgramNavigator userProgramNavigator;

    @Inject
    UserProgramPresenter userProgramPresenter;

    @BindView(R.id.activity_user_program_toolbar)
    Toolbar toolbar;

    private static final String PROGRAM_ID = "com.example.thomas.guitartraining.presentation.activity.PROGRAM_ID";
    private static final String FRAGMENT_TYPE = "com.example.thomas.guitartraining.presentation.activity.FRAGMENT_TYPE";

    public static Intent newInstance(Context context, int fragmentTypeId, String programId) {
        Bundle bundle = new Bundle();
        bundle.putInt(FRAGMENT_TYPE, fragmentTypeId);
        bundle.putString(PROGRAM_ID, programId);
        Intent intent = new Intent(context, UserProgramActivity.class);
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_program);

        ButterKnife.bind(this);
        setFragmentManager();

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        userProgramPresenter.setUserProgramView(this);

        Bundle bundle = getIntent().getExtras();
        int fragmentTypeId = getFragmentTypeFromBundle(bundle);
        String programId = getProgramIdFromBundle(bundle);

        switch (fragmentTypeId) {
            case UserProgramNavigator.FRAGMENT_USER_PROGRAM_DETAILS:
                userProgramNavigator.displayProgramDetailsFragment(programId);
                break;
            case UserProgramNavigator.FRAGMENT_USER_PROGRAM_EDITION:
                userProgramNavigator.displayUserProgramEditionFragment(programId);
        }
    }

    @Override
    public void requestDisplayProgramList() {
        userProgramNavigator.restoreUserPanelActivity();
    }

    @Override
    public void launchProgram(String idProgram) {
        userProgramNavigator.requestLaunchProgram(idProgram);
    }

    @Override
    public void setUserProgramToolbar(String toolbarTitle) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_user_program_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (toolbarTitle != null) {
            toolbar.setTitle(toolbarTitle);
        }
    }

    @Override
    public void displayUserProgramUpdate(ProgramViewModel programViewModel) {
        userProgramNavigator.requestUserProgramUpdate(programViewModel);
    }

    @Override
    public void requestRenderError(Throwable e, int mode, View viewId) {

    }

    @Override
    public void requestRenderErrorString(String error, int mode, View view) {
        userProgramNavigator.renderErrorString(error, mode, view);
    }

    private void setFragmentManager() {
        userProgramNavigator.setFragmentManager(getSupportFragmentManager());
    }

    private int getFragmentTypeFromBundle(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey(FRAGMENT_TYPE)) {
                return bundle.getInt(FRAGMENT_TYPE);
            }
        }
        return 0;
    }

    private String getProgramIdFromBundle(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey(PROGRAM_ID)) {
                return bundle.getString(PROGRAM_ID);
            }
        }
        return null;
    }
}

package com.example.thomas.guitartraining.presentation.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.listener.UserPanelNavigatorListener;
import com.example.thomas.guitartraining.presentation.navigator.UserPanelNavigator;
import com.example.thomas.guitartraining.presentation.presenter.activity.UserPanelPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserPanelActivity extends BaseActivity implements UserPanelNavigatorListener {

    @BindView(R.id.view_toolbar)
    Toolbar toolbar;
    @BindView(R.id.activity_user_panel_navigation_view)
    NavigationView userPanelNavigationView;
    @BindView(R.id.activity_main_drawer_layout)
    DrawerLayout drawerLayout;

    @SuppressWarnings("unused")
    @Inject
    UserPanelPresenter userPanelPresenter;
    @Inject
    UserPanelNavigator userPanelNavigator;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        setFragmentManager();
        initDrawerMenu();

        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawerToggle.isDrawerIndicatorEnabled()) {
                    onBackPressed();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayUserProgramsFragment();
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        userPanelNavigator.onBackPressed();
    }

    @Override
    public void requestRenderError(Throwable e, int mode, View viewId) {
    }

    public void enabledBurger(boolean state) {
        if (!state) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
            drawerToggle.setDrawerIndicatorEnabled(false);
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            drawerToggle.setDrawerIndicatorEnabled(true);
        }
    }

    private void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        switch (menuItem.getItemId()) {
            case R.id.menu_drawer_programs:
                userPanelNavigator.displayUserProgramsFragment();
                break;
            case R.id.menu_drawer_songs:
                userPanelNavigator.displayUserSongsFragment();
                break;
            default:
                userPanelNavigator.displayUserProgramsFragment();
        }

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawerLayout.closeDrawers();
    }

    private void setFragmentManager() {
        userPanelNavigator.setFragmentManager(getFragmentManager());
    }

    private void initDrawerMenu() {
        // Setup drawer view
        setupDrawerContent(userPanelNavigationView);

        // Set a Toolbar to replace the ActionBar.
        setSupportActionBar(toolbar);

        // Find our drawer view
        drawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        drawerLayout.addDrawerListener(drawerToggle);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid view_toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    private void displayUserProgramsFragment() {
        userPanelNavigator.displayUserProgramsFragment();
    }
}

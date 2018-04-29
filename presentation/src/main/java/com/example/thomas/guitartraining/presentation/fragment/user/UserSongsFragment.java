package com.example.thomas.guitartraining.presentation.fragment.user;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.UserPanelActivity;
import com.example.thomas.guitartraining.presentation.fragment.BaseFragment;
import com.example.thomas.guitartraining.presentation.presenter.user.UserSongsPresenter;
import com.example.thomas.guitartraining.presentation.activity.listener.UserPanelNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.UserSongsView;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class UserSongsFragment extends BaseFragment implements UserSongsView {

    @Inject
    UserSongsPresenter userSongsPresenter;

    private View rootView;

    public static UserSongsFragment newInstance() {

        Bundle args = new Bundle();

        UserSongsFragment fragment = new UserSongsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_user_songs, container, false);

        ButterKnife.bind(this, rootView);

        userSongsPresenter.setUserSongsView(this);
        userSongsPresenter.setUserPanelNavigatorListener((UserPanelNavigatorListener) this.getActivity());

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

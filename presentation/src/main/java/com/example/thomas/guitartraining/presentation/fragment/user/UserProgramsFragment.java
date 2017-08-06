package com.example.thomas.guitartraining.presentation.fragment.user;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.MainActivity;
import com.example.thomas.guitartraining.presentation.presenter.user.UserProgramsPresenter;
import com.example.thomas.guitartraining.presentation.activity.listener.MainNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramsView;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class UserProgramsFragment extends Fragment implements UserProgramsView {

    @Inject
    UserProgramsPresenter userProgramsPresenter;

    private View rootView;

    public static UserProgramsFragment newInstance() {

        Bundle args = new Bundle();

        UserProgramsFragment fragment = new UserProgramsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.user_programs_fragment, container, false);

        ButterKnife.bind(this, rootView);
        ((MainActivity) getActivity()).getActivityComponent().inject(this);

        userProgramsPresenter.setUserProgramsView(this);
        userProgramsPresenter.setMainNavigatorListener((MainNavigatorListener) this.getActivity());

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

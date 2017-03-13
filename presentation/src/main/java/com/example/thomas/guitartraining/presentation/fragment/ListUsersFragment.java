package com.example.thomas.guitartraining.presentation.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.MainActivity;
import com.example.thomas.guitartraining.presentation.adapter.ListUsersAdapter;
import com.example.thomas.guitartraining.presentation.presenter.ListUsersPresenter;
import com.example.thomas.guitartraining.presentation.view.ListUsersView;
import com.example.thomas.guitartraining.presentation.view.MainNavigatorListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Thomas on 13/03/2017.
 */

public class ListUsersFragment extends Fragment implements ListUsersView {

    @Inject
    ListUsersPresenter listUsersPresenter;
    @Inject
    ListUsersAdapter listUsersAdapter;

    @BindView(R.id.list_users_RV)
    RecyclerView listUsersRV;

    View rootView;

    public static ListUsersFragment newInstance() {
        return new ListUsersFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.list_users_fragment, container, false);
        ((MainActivity) getActivity()).getActivityComponent().inject(this);
        listUsersPresenter.setListUsersView(this);
        listUsersPresenter.setMainNavigatorListener((MainNavigatorListener) this.getActivity());

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, rootView);
        initRecyclerView();
    }

    private void initRecyclerView() {
        listUsersRV.setHasFixedSize(true);
        listUsersRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        listUsersRV.setAdapter(listUsersAdapter);

    }
}

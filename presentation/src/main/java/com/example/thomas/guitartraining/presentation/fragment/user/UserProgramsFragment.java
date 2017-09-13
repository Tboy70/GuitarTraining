package com.example.thomas.guitartraining.presentation.fragment.user;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.model.Program;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.UserPanelActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.UserPanelNavigatorListener;
import com.example.thomas.guitartraining.presentation.fragment.ui.adapter.UserProgramsListAdapter;
import com.example.thomas.guitartraining.presentation.fragment.ui.adapter.UserProgramsListAdapterListener;
import com.example.thomas.guitartraining.presentation.presenter.user.UserProgramsPresenter;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramsView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserProgramsFragment extends Fragment implements UserProgramsView, UserProgramsListAdapterListener {

    @BindView(R.id.fragment_user_programs_list_swipe_refresh_layout)
    SwipeRefreshLayout userProgramsListSwipeRefreshLayout;
    @BindView(R.id.fragment_user_programs_list_recycler_view)
    RecyclerView userProgramsListRecyclerView;
    @BindView(R.id.fragment_user_programs_list_no_program)
    TextView userProgramsListNoProgram;

    @Inject
    UserProgramsPresenter userProgramsPresenter;
    @Inject
    UserProgramsListAdapter userProgramsListAdapter;

    public static UserProgramsFragment newInstance() {

        Bundle args = new Bundle();

        UserProgramsFragment fragment = new UserProgramsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_programs, container, false);

        ButterKnife.bind(this, rootView);
        ((UserPanelActivity) getActivity()).getActivityComponent().inject(this);

        userProgramsPresenter.setUserProgramsView(this);
        userProgramsPresenter.setUserPanelNavigatorListener((UserPanelNavigatorListener) this.getActivity());
        userProgramsListAdapter.setUserProgramsListAdapter(this);

        initRecyclerView();

        userProgramsPresenter.getIdUser(getActivity());

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void displayProgramsList(List<Program> programs) {
        userProgramsListAdapter.updateProgramsList(programs);
        if (programs.isEmpty()) {
            userProgramsListNoProgram.setVisibility(View.VISIBLE);
            userProgramsListRecyclerView.setVisibility(View.GONE);
        } else {
            userProgramsListNoProgram.setVisibility(View.GONE);
            userProgramsListRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        userProgramsListRecyclerView.setLayoutManager(layoutManager);
        userProgramsListRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), layoutManager.getOrientation()));
        userProgramsListRecyclerView.setAdapter(userProgramsListAdapter);

        userProgramsListSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // TODO : Refresh list.
            }
        });
        userProgramsListSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
    }
}

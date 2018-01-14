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
import android.widget.LinearLayout;

import com.example.model.Program;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.UserPanelActivity;
import com.example.thomas.guitartraining.presentation.activity.listener.UserPanelNavigatorListener;
import com.example.thomas.guitartraining.presentation.fragment.ui.adapter.UserProgramsListAdapter;
import com.example.thomas.guitartraining.presentation.fragment.ui.adapter.UserProgramsListAdapterListener;
import com.example.thomas.guitartraining.presentation.presenter.user.UserProgramsListPresenter;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramsListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserProgramsListFragment extends Fragment implements UserProgramsListView, UserProgramsListAdapterListener {

    @BindView(R.id.fragment_user_programs_list_swipe_refresh_layout)
    SwipeRefreshLayout userProgramsListSwipeRefreshLayout;
    @BindView(R.id.fragment_user_programs_list_recycler_view)
    RecyclerView userProgramsListRecyclerView;
    @BindView(R.id.fragment_user_programs_list_no_program_placeholder)
    LinearLayout userProgramsListNoProgramPlaceholder;

    @Inject
    UserProgramsListPresenter userProgramsListPresenter;
    @Inject
    UserProgramsListAdapter userProgramsListAdapter;

    private String idUser;

    public static UserProgramsListFragment newInstance() {

        Bundle args = new Bundle();

        UserProgramsListFragment fragment = new UserProgramsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_programs_list, container, false);

        ButterKnife.bind(this, rootView);
        ((UserPanelActivity) getActivity()).getActivityComponent().inject(this);

        userProgramsListPresenter.setUserProgramsListView(this);
        userProgramsListPresenter.setUserPanelNavigatorListener((UserPanelNavigatorListener) this.getActivity());
        userProgramsListAdapter.setUserProgramsListAdapter(this);

        initRecyclerView();

        this.idUser = userProgramsListPresenter.getIdUser(getActivity());
//        userProgramsListPresenter.retrieveProgramsListByUserId(idUser);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        userProgramsListPresenter.retrieveProgramsListByUserId(idUser);
    }

    @Override
    public void displayProgramsList(List<Program> programs) {
        userProgramsListAdapter.updateProgramsList(programs);
        if (programs.isEmpty()) {
            userProgramsListNoProgramPlaceholder.setVisibility(View.VISIBLE);
            userProgramsListRecyclerView.setVisibility(View.GONE);
        } else {
            userProgramsListNoProgramPlaceholder.setVisibility(View.GONE);
            userProgramsListRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void startRefresh() {
        if (!userProgramsListSwipeRefreshLayout.isRefreshing()) {
            userProgramsListSwipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void stopRefresh() {
        userProgramsListSwipeRefreshLayout.setRefreshing(false);
    }

    @OnClick(R.id.fragment_user_programs_floating_action_button)
    public void handleClickUserProgramsFloatingActionButton() {
        userProgramsListPresenter.addUserProgram(null);
    }

    @Override
    public void onProgramClick(String programId) {
        userProgramsListPresenter.displayProgramDetails(programId);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        userProgramsListRecyclerView.setLayoutManager(layoutManager);
        userProgramsListRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), layoutManager.getOrientation()));
        userProgramsListRecyclerView.setAdapter(userProgramsListAdapter);

        userProgramsListSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                userProgramsListPresenter.retrieveProgramsListByUserId(idUser);
            }
        });
        userProgramsListSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
    }
}

package com.example.thomas.guitartraining.presentation.fragment.program;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.presenter.program.EndProgramPresenter;
import com.example.thomas.guitartraining.presentation.view.EndProgramView;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Last step of a program to congratulate the user.
 */
public class EndProgramFragment extends Fragment implements EndProgramView {

    @Inject
    EndProgramPresenter endProgramPresenter;

    public static EndProgramFragment newInstance() {
        Bundle args = new Bundle();

        EndProgramFragment fragment = new EndProgramFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.end_program_fragment, container, false);

        ButterKnife.bind(this, rootView);

        ((ProgramActivity) getActivity()).getActivityComponent().inject(this);
        endProgramPresenter.setEndProgramView(this);
        endProgramPresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick(R.id.end_program_finish_button)
    public void handleClickEndProgramFinishButton() {
        //TODO : Call this on the presenter ?
        getActivity().onBackPressed();
    }
}

package com.example.thomas.guitartraining.presentation.fragment.program;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.model.Exercise;
import com.example.model.Program;
import com.example.model.Text;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.presenter.program.IntroProgramPresenter;
import com.example.thomas.guitartraining.presentation.activity.listener.ProgramNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.program.IntroProgramView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * First step of a program, before begin the exercises.
 */
public class IntroProgramFragment extends Fragment implements IntroProgramView {

    private static final String ID_PROGRAM = "com.example.thomas.guitartraining.presentation.fragment.program.IntroProgramFragment.ID_PROGRAM";

    @Inject
    IntroProgramPresenter introProgramPresenter;

    @BindView(R.id.intro_program_success)
    LinearLayout introProgramSuccess;

    @BindView(R.id.intro_program_error)
    LinearLayout introProgramError;

    @BindView(R.id.intro_program_name_program)
    TextView introProgramName;

    @BindView(R.id.intro_program_description_program)
    TextView introProgramDescription;

    @BindView(R.id.intro_program_start_button)
    TextView introProgramStartButton;

    private List<Exercise> programExercisesList;
    private int idProgram;

    public static IntroProgramFragment newInstance(int idProgram) {
        Bundle args = new Bundle();
        args.putInt(ID_PROGRAM, idProgram);

        IntroProgramFragment fragment = new IntroProgramFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.intro_program_fragment, container, false);

        ButterKnife.bind(this, rootView);
        ((ProgramActivity) getActivity()).getActivityComponent().inject(this);

        introProgramPresenter.setIntroProgramView(this);
        introProgramPresenter.setProgramNavigatorListener((ProgramNavigatorListener) this.getActivity());

        programExercisesList = new ArrayList<>();

        idProgram = getArguments().getInt(ID_PROGRAM);
        introProgramPresenter.retrieveProgramFromId(this.getActivity(), idProgram);

        setToolbarTitle(idProgram);

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

    @SuppressWarnings("deprecation")
    @Override
    public void updateUISuccess(Program program, Text text) {
        introProgramName.setText(program.getNameProgram());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            introProgramDescription.setText(Html.fromHtml(text.getContentText(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            introProgramDescription.setText((Html.fromHtml(text.getContentText())));
        }
        programExercisesList = program.getExercises();
        setLayoutVisibility(View.VISIBLE, View.GONE);
    }

    @Override
    public void updateUIError() {
        setLayoutVisibility(View.GONE, View.VISIBLE);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.program_activity_menu_toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @OnClick(R.id.intro_program_start_button)
    public void handleClickIntroProgramStartButton() {
        introProgramPresenter.startExercises(programExercisesList);
    }

    @OnClick(R.id.intro_program_error_retry)
    public void handleClickIntroProgramErrorRetry() {
        setLayoutVisibility(View.GONE, View.GONE);
        introProgramPresenter.retrieveProgramFromId(this.getActivity(), idProgram);
    }

    @OnClick(R.id.intro_program_error_give_up)
    public void handleClickIntroProgramErrorGiveUp() {
        this.getActivity().finish();
    }

    private void setLayoutVisibility(int visibilityLayoutSuccess, int visibilityLayoutError) {
        introProgramSuccess.setVisibility(visibilityLayoutSuccess);
        introProgramError.setVisibility(visibilityLayoutError);
    }

    private void setToolbarTitle(int idProgram) {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.activity_program_toolbar);
        switch (idProgram) {
            case 1:
                toolbar.setTitle(getActivity().getString(R.string.toolbar_title_theoretical_program));
                toolbar.setTitleTextColor(ContextCompat.getColor(getActivity(), android.R.color.white));
                break;
            case 2:
                toolbar.setTitle(getActivity().getString(R.string.toolbar_title_technical_program));
                toolbar.setTitleTextColor(ContextCompat.getColor(getActivity(), android.R.color.white));
                break;
            default:
                toolbar.setTitle(getActivity().getString(R.string.toolbar_title_custom_program));
                toolbar.setTitleTextColor(ContextCompat.getColor(getActivity(), android.R.color.white));
                break;
        }
    }
}

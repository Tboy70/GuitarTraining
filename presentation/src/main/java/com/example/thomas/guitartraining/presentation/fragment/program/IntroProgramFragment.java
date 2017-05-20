package com.example.thomas.guitartraining.presentation.fragment.program;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.model.Exercise;
import com.example.model.Program;
import com.example.model.Text;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.ProgramActivity;
import com.example.thomas.guitartraining.presentation.presenter.program.IntroProgramPresenter;
import com.example.thomas.guitartraining.presentation.view.ProgramNavigatorListener;
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

    public static final String ID_PROGRAM = "com.example.thomas.guitartraining.presentation.fragment.program.IntroProgramFragment.ID_PROGRAM";

    @Inject
    IntroProgramPresenter introProgramPresenter;

    @BindView(R.id.intro_program_name_program)
    TextView introProgramName;

    @BindView(R.id.intro_program_description_program)
    TextView introProgramDescription;

    @BindView(R.id.intro_program_start_button)
    TextView introProgramStartButton;

    private List<Exercise> programExercisesList;

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

        // TODO : See where to put this to have no latency.
        int idProgram = getArguments().getInt(ID_PROGRAM);
        introProgramPresenter.retrieveProgramFromId(this.getActivity(), idProgram);

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

    @Override
    public void updateUI(Program program, Text text) {
        introProgramName.setText(program.getNameProgram());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            introProgramDescription.setText(Html.fromHtml(text.getContentText(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            introProgramDescription.setText((Html.fromHtml(text.getContentText())));
        }
        programExercisesList = program.getExercises();
        introProgramDescription.setVisibility(View.VISIBLE);
        introProgramStartButton.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.intro_program_start_button)
    public void handleClickIntroProgramStartButton() {
        introProgramPresenter.startExercises(programExercisesList);
    }
}

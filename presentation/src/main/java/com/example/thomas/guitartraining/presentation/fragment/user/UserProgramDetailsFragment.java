package com.example.thomas.guitartraining.presentation.fragment.user;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.model.Exercise;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel.ProgramViewModel;
import com.example.thomas.guitartraining.presentation.presenter.user.UserProgramDetailsPresenter;
import com.example.thomas.guitartraining.presentation.utils.ExerciseUtils;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramDetailsView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserProgramDetailsFragment extends Fragment implements UserProgramDetailsView {

    @Inject
    UserProgramDetailsPresenter userProgramsListPresenter;

    @BindView(R.id.fragment_user_program_details_name)
    TextView userProgramDetailsName;
    @BindView(R.id.fragment_user_program_details_description)
    TextView userProgramDetailsDescription;
    @BindView(R.id.fragment_user_program_details_exercises)
    FrameLayout userProgramDetailsExercises;
    @BindView(R.id.fragment_user_program_details_remove_button)
    Button userProgramDetailsRemoveButton;

    private static final String PROGRAM_ID = "com.example.thomas.guitartraining.presentation.fragment.user.PROGRAM_ID";

    private String programId;

    public static Fragment newInstance(String programId) {
        Bundle bundle = new Bundle();
        bundle.putString(PROGRAM_ID, programId);
        UserProgramDetailsFragment fragment = new UserProgramDetailsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_program_details, container, false);

        ButterKnife.bind(this, view);
        ((BaseActivity) getActivity()).getActivityComponent().inject(this);

        setHasOptionsMenu(true);

        userProgramsListPresenter.setUserProgramDetailsView(this);

        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey(PROGRAM_ID)) {
                programId = bundle.getString(PROGRAM_ID);
                if (programId != null && (programId.equals("1") || programId.equals("2"))) {
                    userProgramDetailsRemoveButton.setVisibility(View.GONE);
                }
            }
        }

        userProgramsListPresenter.getProgramById(programId);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setToolbar(getActivity().getString(R.string.toolbar_title_details_program));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void displayUserProgramDetails(ProgramViewModel programViewModel) {
        userProgramDetailsName.setText(programViewModel.getProgram().getNameProgram());

        String descriptionProgram = programViewModel.getProgram().getDescriptionProgram();
        if (descriptionProgram.isEmpty()) {
            userProgramDetailsDescription.setText(getActivity().getString(R.string.fragment_user_details_program_no_description_text));
        } else {
            userProgramDetailsDescription.setText(descriptionProgram);
        }

        LinearLayout exercisesLinearLayout = new LinearLayout(getActivity());
        exercisesLinearLayout.setOrientation(LinearLayout.VERTICAL);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        exercisesLinearLayout.setLayoutParams(layoutParams);

        for (Exercise exercise : programViewModel.getProgram().getExercises()) {
            TextView nameExercise = new TextView(getActivity());
            nameExercise.setText(ExerciseUtils.convertTypeExerciseToName(exercise.getTypeExercise(), getActivity()));
            nameExercise.setTextColor(ContextCompat.getColor(getActivity(), android.R.color.black));
            nameExercise.setTextSize(15); // TODO: 02/10/2017  See how to get dimens value

            TextView durationExercise = new TextView(getActivity());
            if (Build.VERSION.SDK_INT < 23) {
                durationExercise.setTextAppearance(getActivity(), R.style.TextAppearance_AppCompat_Caption);
            } else {
                durationExercise.setTextAppearance(R.style.TextAppearance_AppCompat_Caption);
            }
            durationExercise.setText(String.valueOf(exercise.getDurationExercise()));
            durationExercise.setTextSize(15); // TODO: 02/10/2017 See how to get dimens value

            exercisesLinearLayout.addView(nameExercise, 0);
            exercisesLinearLayout.addView(durationExercise, 1);
        }

        userProgramDetailsExercises.addView(exercisesLinearLayout);
    }

    @OnClick(R.id.fragment_user_program_details_start_button)
    public void handleClickUserProgramDetailsStartButton() {
        userProgramsListPresenter.launchProgram();
    }

    @OnClick(R.id.fragment_user_program_details_remove_button)
    public void handleClickUserProgramDetailsRemoveButton() {
        userProgramsListPresenter.removeProgram();
    }

    public void setToolbar(String toolbarTitle) {
        userProgramsListPresenter.setToolbar(toolbarTitle);
    }
}

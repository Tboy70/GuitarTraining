package com.example.thomas.guitartraining.presentation.fragment.user;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.data.values.ExercisesTypeValues;
import com.example.model.Exercise;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel.ProgramViewModel;
import com.example.thomas.guitartraining.presentation.presenter.user.UserProgramDetailsPresenter;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramDetailsView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserProgramDetailsFragment extends Fragment implements UserProgramDetailsView {

    @Inject
    UserProgramDetailsPresenter userProgramsListPresenter;

    @BindView(R.id.fragment_user_program_details_name)
    TextView userProgramDetailsName;
    @BindView(R.id.fragment_user_program_details_exercises)
    FrameLayout userProgramDetailsExercises;

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
            }
        }

        userProgramsListPresenter.getProgramById(programId);

        return view;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void displayUserProgramDetails(ProgramViewModel programViewModel) {
        userProgramDetailsName.setText(programViewModel.getProgram().getNameProgram());
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);

        for (Exercise exercise : programViewModel.getProgram().getExercises()) {
            TextView nameExercise = new TextView(getActivity());
            nameExercise.setText(convertTypeExerciseToName(Integer.valueOf(exercise.getTypeExercise())));

            TextView durationExercise = new TextView(getActivity());
            if (Build.VERSION.SDK_INT < 23) {
                durationExercise.setTextAppearance(getActivity(), R.style.TextAppearance_AppCompat_Caption);
            } else {
                durationExercise.setTextAppearance(R.style.TextAppearance_AppCompat_Caption);
            }
            durationExercise.setText(String.valueOf(exercise.getDurationExercise()));

            linearLayout.addView(nameExercise, 0);
            linearLayout.addView(durationExercise, 1);
        }

        userProgramDetailsExercises.addView(linearLayout);
    }

    private String convertTypeExerciseToName(int typeExercise) {
        switch (typeExercise) {
            case ExercisesTypeValues.EXERCISE_SCALE:
                return getActivity().getString(R.string.exercise_scale_title_text);
            case ExercisesTypeValues.EXERCISE_MODE:
                return getActivity().getString(R.string.exercise_mode_title_text);
            case ExercisesTypeValues.EXERCISE_PULL_OFF_HAMMER_ON:
                return getActivity().getString(R.string.exercise_palm_mute_title_text);
            case ExercisesTypeValues.EXERCISE_BEND_SLIDE:
                return getActivity().getString(R.string.exercise_bend_slide_title_text);
            case ExercisesTypeValues.EXERCISE_BACK_FORTH:
                return getActivity().getString(R.string.exercise_back_forth_title_text);
            case ExercisesTypeValues.EXERCISE_PALM_MUTE:
                return getActivity().getString(R.string.exercise_palm_mute_title_text);
            case ExercisesTypeValues.EXERCISE_SKIP_STRING:
                return getActivity().getString(R.string.exercise_skip_string_title_text);
            case ExercisesTypeValues.EXERCISE_TAPPING:
                return getActivity().getString(R.string.exercise_tapping_title_text);
            case ExercisesTypeValues.EXERCISE_SWEEP_PICKING:
                return getActivity().getString(R.string.exercise_sweep_picking_title_text);
            case ExercisesTypeValues.EXERCISE_SPEED:
                return getActivity().getString(R.string.exercise_speed_title_text);
            default:
                return getActivity().getString(R.string.generic_error_title_text);
        }
    }
}

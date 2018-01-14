package com.example.thomas.guitartraining.presentation.fragment.user;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.model.Exercise;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.component.fragment.ExercisesUIComponent;
import com.example.thomas.guitartraining.presentation.component.fragment.listener.ExercisesUIComponentListener;
import com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel.ProgramViewModel;
import com.example.thomas.guitartraining.presentation.listener.AddExerciseListener;
import com.example.thomas.guitartraining.presentation.presenter.user.UserProgramUpdatePresenter;
import com.example.thomas.guitartraining.presentation.utils.ExerciseUtils;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramUpdateView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserProgramUpdateFragment extends Fragment implements UserProgramUpdateView {

    @BindView(R.id.fragment_user_program_update_name)
    EditText userProgramUpdateName;
    @BindView(R.id.fragment_user_program_update_description)
    EditText userProgramUpdateDescription;
    @BindView(R.id.fragment_user_program_update_exercises)
    LinearLayout userProgramUpdateExercisesLayout;

    @Inject
    UserProgramUpdatePresenter userProgramUpdatePresenter;

    private static final String PROGRAM_ID = "com.example.thomas.guitartraining.presentation.fragment.user.PROGRAM_ID";
    private static final String PROGRAM_NAME = "com.example.thomas.guitartraining.presentation.fragment.user.PROGRAM_NAME";
    private static final String PROGRAM_DESCRIPTION = "com.example.thomas.guitartraining.presentation.fragment.user.PROGRAM_DESCRIPTION";
    private static final String PROGRAM_LIST_EXERCISES = "com.example.thomas.guitartraining.presentation.fragment.user.PROGRAM_LIST_EXERCISES";

    private String programId;
    private String programName;
    private String programDescription;
    private List<Exercise> programListExercises;
    private List<Exercise> exercisesToBeRemoved;

    private ExercisesUIComponent exercisesUIComponent;

    public static Fragment newInstance(ProgramViewModel programViewModel) {
        Bundle bundle = new Bundle();
        bundle.putString(PROGRAM_ID, programViewModel.getProgram().getIdProgram());
        bundle.putString(PROGRAM_NAME, programViewModel.getProgram().getNameProgram());
        bundle.putString(PROGRAM_DESCRIPTION, programViewModel.getProgram().getDescriptionProgram());
        bundle.putSerializable(PROGRAM_LIST_EXERCISES, (Serializable) programViewModel.getProgram().getExercises());
        UserProgramUpdateFragment fragment = new UserProgramUpdateFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_program_update, container, false);

        ButterKnife.bind(this, view);
        ((BaseActivity) getActivity()).getActivityComponent().inject(this);

        setHasOptionsMenu(true);

        userProgramUpdatePresenter.setUserProgramUpdateView(this);
        this.exercisesUIComponent = new ExercisesUIComponent();

        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey(PROGRAM_ID)) {
                programId = bundle.getString(PROGRAM_ID);
            }
            if (bundle.containsKey(PROGRAM_NAME)) {
                programName = bundle.getString(PROGRAM_NAME);
            }
            if (bundle.containsKey(PROGRAM_DESCRIPTION)) {
                programDescription = bundle.getString(PROGRAM_DESCRIPTION);
            }
            if (bundle.containsKey(PROGRAM_LIST_EXERCISES)) {
                programListExercises = (List<Exercise>) bundle.getSerializable(PROGRAM_LIST_EXERCISES);
            }
        }

        initEditText();
        initExercisesList();
        exercisesToBeRemoved = new ArrayList<>();

        return view;
    }

    @OnClick(R.id.fragment_user_program_update_validate_button)
    public void handleClickUserProgramUpdateValidateButton() {
        for (int i = 0; i < userProgramUpdateExercisesLayout.getChildCount(); i++) {
            programListExercises.get(i).setTypeExercise(
                    ExerciseUtils.getTypeExerciseIdByName(
                            (((Button)
                                    ((LinearLayout)
                                            ((LinearLayout) userProgramUpdateExercisesLayout.getChildAt(i))
                                                    .getChildAt(0)).getChildAt(0))).getText().toString(),
                            getActivity())
            );
            programListExercises.get(i).setDurationExercise(
                    Integer.valueOf((((EditText)
                            ((LinearLayout)
                                    ((LinearLayout) userProgramUpdateExercisesLayout.getChildAt(i))
                                            .getChildAt(0)).getChildAt(1))).getText().toString())
            );
        }

        programListExercises.removeAll(exercisesToBeRemoved);
        userProgramUpdatePresenter.checkInformationAndValidateUpdate(
                programId, userProgramUpdateName.getText().toString(),
                userProgramUpdateDescription.getText().toString(),
                programListExercises, exercisesToBeRemoved);
    }

    private void initEditText() {
        userProgramUpdateName.setText(programName);
        userProgramUpdateDescription.setText(programDescription);
    }

    private void initExercisesList() {
        for (final Exercise exercise : programListExercises) {
            LinearLayout horizontalLayoutContainingAllElements = exercisesUIComponent.createNewExercise(getActivity(), new ExercisesUIComponentListener() {
                        @Override
                        public void setTypeExerciseButtonAction(final Button buttonTypeExercise, EditText durationExercise) {
                            userProgramUpdatePresenter.showSimpleDialog(new AddExerciseListener() {
                                @Override
                                public void onExerciseChosen(String selectedItem) {
                                    buttonTypeExercise.setText(selectedItem);
                                }

                                @Override
                                public void onAllInformationCompleted() {

                                }
                            });
                        }

                        @Override
                        public void setDurationExerciseAction(EditText durationExercise, Button buttonTypeExercise) {

                        }

                        @Override
                        public void addExerciseToBeRemoved() {
                            exercisesToBeRemoved.add(exercise);
                        }
                    }, ExerciseUtils.convertTypeExerciseToName(exercise.getTypeExercise(), getActivity()),
                    String.valueOf(exercise.getDurationExercise()),
                    ExercisesUIComponent.UPDATE_STATE);

            userProgramUpdateExercisesLayout.addView(horizontalLayoutContainingAllElements);
        }
    }
}
package com.example.thomas.guitartraining.presentation.fragment.user;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.component.fragment.ExercisesUIComponent;
import com.example.thomas.guitartraining.presentation.component.fragment.listener.ExercisesUIComponentListener;
import com.example.thomas.guitartraining.presentation.listener.AddExerciseListener;
import com.example.thomas.guitartraining.presentation.presenter.user.UserProgramCreationPresenter;
import com.example.thomas.guitartraining.presentation.utils.ExerciseUtils;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramCreationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserProgramCreationFragment extends Fragment implements UserProgramCreationView {

    @BindView(R.id.fragment_user_program_creation_name)
    EditText userProgramCreationName;
    @BindView(R.id.fragment_user_program_creation_description)
    EditText userProgramCreationDescription;
    @BindView(R.id.fragment_user_program_creation_exercises)
    LinearLayout userProgramCreationExercisesLayout;
    @BindView(R.id.fragment_user_program_creation_add_exercise)
    Button userProgramCreationAddExercise;
    @BindView(R.id.fragment_user_program_creation_validation)
    Button userProgramCreationValidation;

    @Inject
    UserProgramCreationPresenter userProgramCreationPresenter;

    private ExercisesUIComponent exercisesUIComponent;

    public UserProgramCreationFragment() {
    }

    public static Fragment newInstance() {
        return new UserProgramCreationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_program_creation, container, false);

        ButterKnife.bind(this, view);
        ((BaseActivity) getActivity()).getActivityComponent().inject(this);

        setHasOptionsMenu(true);

        userProgramCreationPresenter.setUserProgramCreationView(this);
        this.exercisesUIComponent = new ExercisesUIComponent();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setToolbar(getActivity().getString(R.string.toolbar_title_creation_program));
    }

    @OnClick(R.id.fragment_user_program_creation_add_exercise)
    public void handleClickUserProgramAddExercise() {
        userProgramCreationPresenter.requestAddExercise();
    }

    @OnClick(R.id.fragment_user_program_creation_validation)
    public void handleClickUserProgramValidation() {
        SparseArray<String> exercises = new SparseArray<>();

        for (int i = 0; i < userProgramCreationExercisesLayout.getChildCount(); i++) {
            exercises.append(ExerciseUtils.getTypeExerciseIdByName(
                    (((Button)
                            ((LinearLayout)
                                    ((LinearLayout) userProgramCreationExercisesLayout.getChildAt(i))
                                            .getChildAt(0)).getChildAt(0))).getText().toString(),
                    getActivity()),
                    (((EditText)
                            ((LinearLayout)
                                    ((LinearLayout) userProgramCreationExercisesLayout.getChildAt(i))
                                            .getChildAt(0)).getChildAt(1))).getText().toString());
        }
        userProgramCreationPresenter.checkInformationAndValidateCreation(userProgramCreationName.getText().toString(), userProgramCreationDescription.getText().toString(), exercises);
    }

    @Override
    public void addFieldToCreateExercise() {
        LinearLayout horizontalLayoutContainingAllElements = exercisesUIComponent.createNewExercise(getActivity(), new ExercisesUIComponentListener() {
                    @Override
                    public void setTypeExerciseButtonAction(final Button buttonTypeExercise, final EditText durationExercise) {
                        userProgramCreationPresenter.showSimpleDialog(new AddExerciseListener() {
                            @Override
                            public void onExerciseChosen(String selectedItem) {
                                buttonTypeExercise.setText(selectedItem);
                            }

                            @Override
                            public void onAllInformationCompleted() {
                                if ((durationExercise.getText() != null || !String.valueOf(durationExercise.getText()).equals("")) && buttonTypeExercise.getText() != "Type d'exercise") {
                                    userProgramCreationAddExercise.setEnabled(true);
                                } else {
                                    userProgramCreationAddExercise.setEnabled(false);
                                }
                            }
                        });
                    }

                    @Override
                    public void setDurationExerciseAction(EditText durationExercise, Button buttonTypeExercise) {
                        if ((durationExercise.getText() != null || !String.valueOf(durationExercise.getText()).equals("")) && buttonTypeExercise.getText() != "Type d'exercise") {
                            userProgramCreationAddExercise.setEnabled(true);
                        } else {
                            userProgramCreationAddExercise.setEnabled(false);
                        }
                    }

                    @Override
                    public void addExerciseToBeRemoved() {
                    }
                }, null,
                null,
                ExercisesUIComponent.CREATE_STATE);

        userProgramCreationExercisesLayout.addView(horizontalLayoutContainingAllElements);
    }

    public void setToolbar(String toolbarTitle) {
        userProgramCreationPresenter.setToolbar(toolbarTitle);
    }
}

package com.example.thomas.guitartraining.presentation.fragment.user;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.BaseActivity;
import com.example.thomas.guitartraining.presentation.listener.AddExerciseListener;
import com.example.thomas.guitartraining.presentation.presenter.user.UserProgramCreationPresenter;
import com.example.thomas.guitartraining.presentation.utils.ExerciseUtils;
import com.example.thomas.guitartraining.presentation.view.user.UserProgramCreationView;

import java.util.HashMap;
import java.util.Map;

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

    private static final int NB_ITEMS_BY_VIEW = 2;

    private Button buttonTypeExercise;
    private EditText durationExercise;

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
        // TODO : Check sparse array
        Map<Integer, String> exercises = new HashMap<>();

        for (int i = 0; i < userProgramCreationExercisesLayout.getChildCount(); i++) {
            if (i % NB_ITEMS_BY_VIEW == 0) {
                exercises.put(
                        ExerciseUtils.getTypeExerciseIdByName(((Button) userProgramCreationExercisesLayout.getChildAt(i)).getText().toString(),
                                getActivity()),
                                ((EditText) userProgramCreationExercisesLayout.getChildAt(i + 1)).getText().toString());
            }
        }
        userProgramCreationPresenter.checkInformationAndValidateCreation(userProgramCreationName.getText().toString(), userProgramCreationDescription.getText().toString(), exercises);
    }

    @Override
    public void addFieldToCreateExercise() {
        createUIViews();
        setListenersToUIViews();

        userProgramCreationExercisesLayout.addView(buttonTypeExercise);
        userProgramCreationExercisesLayout.addView(durationExercise);
    }

    public void setToolbar(String toolbarTitle) {
        userProgramCreationPresenter.setToolbar(toolbarTitle);
    }

    private void createUIViews() {
        buttonTypeExercise = new Button(getActivity());
        buttonTypeExercise.setCompoundDrawables(null, null, ContextCompat.getDrawable(getActivity(), R.drawable.ic_dropdown_black), null);
        buttonTypeExercise.setText(getString(R.string.fragment_user_programs_creation_type_exercise_text));

        durationExercise = new EditText(getActivity());
        durationExercise.setHint(R.string.fragment_user_programs_creation_type_exercise_text);
    }

    private void setListenersToUIViews() {
        buttonTypeExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });

        durationExercise.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if ((durationExercise.getText() != null || !String.valueOf(durationExercise.getText()).equals("")) && buttonTypeExercise.getText() != "Type d'exercise") {
                    userProgramCreationAddExercise.setEnabled(true);
                } else {
                    userProgramCreationAddExercise.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}

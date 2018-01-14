package com.example.thomas.guitartraining.presentation.component.fragment;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.component.fragment.listener.ExercisesUIComponentListener;

@PerActivity
public class ExercisesUIComponent {

    public static final int CREATE_STATE = 0;
    public static final int UPDATE_STATE = 1;

    private LinearLayout horizontalLayoutContainingAllElements;
    private LinearLayout verticalLayoutContainingTypeExerciseAndDurationExercise;

    private Button buttonTypeExercise;
    private EditText durationExercise;
    private ImageButton removeExerciseButton;

    public LinearLayout createNewExercise(Activity activity, final ExercisesUIComponentListener exercisesUIComponentListener, String textButton, String textDuration, int state) {
        createLayout(activity);
        createUIViews(activity, textButton, textDuration, state);
        setListeners(durationExercise, buttonTypeExercise, removeExerciseButton, exercisesUIComponentListener, state);
        addViews(verticalLayoutContainingTypeExerciseAndDurationExercise, horizontalLayoutContainingAllElements);

        return horizontalLayoutContainingAllElements;
    }

    private void createLayout(Activity activity) {
        horizontalLayoutContainingAllElements = new LinearLayout(activity);
        horizontalLayoutContainingAllElements.setOrientation(LinearLayout.HORIZONTAL);

        verticalLayoutContainingTypeExerciseAndDurationExercise = new LinearLayout(activity);
        verticalLayoutContainingTypeExerciseAndDurationExercise.setOrientation(LinearLayout.VERTICAL);
    }

    private void createUIViews(Activity activity, String textButton, String textDuration, int state) {
        buttonTypeExercise = new Button(activity);
        buttonTypeExercise.setCompoundDrawables(null, null, ContextCompat.getDrawable(activity, R.drawable.ic_dropdown_black), null);
        if (state == CREATE_STATE) {
            buttonTypeExercise.setText(activity.getString(R.string.fragment_user_programs_creation_type_exercise_text));
        } else if (state == UPDATE_STATE) {
            buttonTypeExercise.setText(textButton);
        }

        durationExercise = new EditText(activity);
        if (state == CREATE_STATE) {
            durationExercise.setHint(R.string.fragment_user_programs_creation_duration_exercise_text);
        } else if (state == UPDATE_STATE) {
            durationExercise.setText(textDuration);
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1.0f;
        params.gravity = Gravity.CENTER;

        removeExerciseButton = new ImageButton(activity);
        removeExerciseButton.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_delete));
        removeExerciseButton.setBackgroundColor(ContextCompat.getColor(activity, android.R.color.transparent));
        removeExerciseButton.setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary));
        removeExerciseButton.setLayoutParams(params);
    }

    private void setListeners(final EditText durationExercise, final Button buttonTypeExercise, ImageButton removeExerciseButton, final ExercisesUIComponentListener exercisesUIComponentListener, final int state) {
        durationExercise.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                exercisesUIComponentListener.setDurationExerciseAction(durationExercise, buttonTypeExercise);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        buttonTypeExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercisesUIComponentListener.setTypeExerciseButtonAction(buttonTypeExercise, durationExercise);
            }
        });

        removeExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewGroup) v.getParent().getParent()).removeView((ViewGroup) v.getParent());
                if (state == UPDATE_STATE) {
                    exercisesUIComponentListener.addExerciseToBeRemoved();
                }
            }
        });
    }

    private void addViews(LinearLayout verticalLayoutContainingTypeExerciseAndDurationExercise, LinearLayout horizontalLayoutContainingAllElements) {
        verticalLayoutContainingTypeExerciseAndDurationExercise.addView(buttonTypeExercise);
        verticalLayoutContainingTypeExerciseAndDurationExercise.addView(durationExercise);

        horizontalLayoutContainingAllElements.addView(verticalLayoutContainingTypeExerciseAndDurationExercise);

        horizontalLayoutContainingAllElements.addView(removeExerciseButton);
    }
}

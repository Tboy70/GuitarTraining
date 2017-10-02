package com.example.thomas.guitartraining.presentation.fragment.ui.view.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.model.Exercise;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.fragment.ui.adapter.UserProgramsListAdapterListener;
import com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel.ProgramViewModel;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgramViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.view_user_programs_list_item_name)
    TextView viewUserProgramsListItemName;

    @BindView(R.id.view_user_programs_list_item_nb_exercises)
    TextView viewUserProgramsListItemNbExercises;

    @BindView(R.id.view_user_programs_list_item_total_duration_exercises)
    TextView viewUserProgramsListItemTotalDurationExercises;

    private View currentView;
    private Context context;

    private UserProgramsListAdapterListener userProgramsListAdapterListener;
    private ProgramViewModel programViewModel;

    public ProgramViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.currentView = itemView;
        this.context = context;
    }

    public void bindProgram(final ProgramViewModel programViewModel, final UserProgramsListAdapterListener userProgramsListAdapterListener) {
        this.programViewModel = programViewModel;
        this.userProgramsListAdapterListener = userProgramsListAdapterListener;

        viewUserProgramsListItemName.setText(programViewModel.getProgram().getNameProgram());
        viewUserProgramsListItemNbExercises.setText(String.format(
                Locale.FRANCE,
                context.getString(R.string.fragment_user_programs_list_nb_exercises_text),
                String.valueOf(programViewModel.getProgram().getExercises().size())));

        viewUserProgramsListItemTotalDurationExercises.setText(String.format(
                Locale.FRANCE,
                context.getString(R.string.fragment_user_programs_list_total_duration_exercises_text),
                String.valueOf(calculateTotalDurationProgram(programViewModel))
        ));

        currentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userProgramsListAdapterListener.onProgramClick(programViewModel.getProgram().getIdProgram());
            }
        });
    }

    private int calculateTotalDurationProgram(ProgramViewModel programViewModel) {
        int totalDuration = 0;
        for (Exercise exercise : programViewModel.getProgram().getExercises()) {
            totalDuration += exercise.getDurationExercise();
        }
        return totalDuration;
    }
}

package com.example.thomas.guitartraining.presentation.fragment.ui.view.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.fragment.ui.adapter.UserProgramsListAdapterListener;
import com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel.ProgramViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgramViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.view_user_programs_list_item_name)
    TextView viewUserProgramsListItemName;

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

    public void bindProgram(ProgramViewModel programViewModel, UserProgramsListAdapterListener userProgramsListAdapterListener) {
        this.programViewModel = programViewModel;
        this.userProgramsListAdapterListener = userProgramsListAdapterListener;

        viewUserProgramsListItemName.setText(programViewModel.getProgram().getNameProgram());
    }
}

package com.example.thomas.guitartraining.presentation.fragment.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.model.Program;
import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.fragment.ui.view.viewholder.ProgramViewHolder;
import com.example.thomas.guitartraining.presentation.fragment.ui.view.viewmodel.ProgramViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class UserProgramsListAdapter extends RecyclerView.Adapter<ProgramViewHolder> {

    private final Activity activity;
    private UserProgramsListAdapterListener userProgramsListAdapterListener;
    private List<Program> programList;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public UserProgramsListAdapter(Activity activity) {
        this.activity = activity;
        this.programList = new ArrayList<>();
    }

    @Override
    public ProgramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_user_programs_list_item, parent, false);
        return new ProgramViewHolder(view, activity);
    }

    @Override
    public void onBindViewHolder(ProgramViewHolder holder, int position) {
        holder.bindProgram(new ProgramViewModel(programList.get(position), activity), userProgramsListAdapterListener);
    }

    @Override
    public int getItemCount() {
        return programList.size();
    }

    public void setUserProgramsListAdapter(UserProgramsListAdapterListener userProgramsListAdapterListener) {
        this.userProgramsListAdapterListener = userProgramsListAdapterListener;
    }

    public void updateProgramsList(List<Program> programs) {
        clearList();
        if (programs != null) {
            programList.addAll(programs);
            notifyDataSetChanged();
        }
    }

    private void clearList() {
        if (programList != null) {
            programList.clear();
            notifyDataSetChanged();
        }
    }
}

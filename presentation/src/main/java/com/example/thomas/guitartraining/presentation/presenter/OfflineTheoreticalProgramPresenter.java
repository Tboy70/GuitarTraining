package com.example.thomas.guitartraining.presentation.presenter;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.ProgramRepository;
import com.example.thomas.guitartraining.presentation.view.OfflineNavigatorListener;
import com.example.thomas.guitartraining.presentation.view.OfflineTheoreticalProgramView;

import javax.inject.Inject;

/**
 * Created by Thomas on 04/05/2017.
 */

public class OfflineTheoreticalProgramPresenter {

    private OfflineTheoreticalProgramView offlineTheoreticalProgramView;
    private OfflineNavigatorListener offlineNavigatorListener;
    private ProgramRepository programRepository;

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    @Inject
    OfflineTheoreticalProgramPresenter(ProgramRepository programRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.programRepository = programRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    public void setOfflineTheoreticalProgramView(OfflineTheoreticalProgramView offlineTheoreticalProgramView) {
        this.offlineTheoreticalProgramView = offlineTheoreticalProgramView;
    }

    public void setOfflineNavigatorListener(OfflineNavigatorListener offlineNavigatorListener) {
        this.offlineNavigatorListener = offlineNavigatorListener;
    }

    public void getOfflineTheoreticalProgram(int idProgram) {
    }
}

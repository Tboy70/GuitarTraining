package com.example.thomas.guitartraining.presentation.component.presenter.listener;

public interface SingleChoiceMaterialDialogListener {

    void onItemSelected(String selectedItem);

    void onCancelClick();

    void getPositionSelected(int which);
}

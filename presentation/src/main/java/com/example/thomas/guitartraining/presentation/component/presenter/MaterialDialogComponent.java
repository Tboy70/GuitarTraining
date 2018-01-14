package com.example.thomas.guitartraining.presentation.component.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.component.presenter.listener.SingleChoiceMaterialDialogListener;

import java.util.List;

import javax.inject.Inject;

@PerActivity
public class MaterialDialogComponent {

    private Activity activity;
    private MaterialDialog materialDialog;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public MaterialDialogComponent(Activity activity) {
        this.activity = activity;
    }

    public void showSingleChoiceDialog(String title, final List<String> items, String selectedItem, int color, boolean cancelable,
                                       final SingleChoiceMaterialDialogListener singleChoiceMaterialDialogListener) {
        int selectedIndex = getSelectedItemIndex(items, selectedItem);
        materialDialog = new MaterialDialog.Builder(activity)
                .title(title)
                .items(items)
                .itemsCallbackSingleChoice(selectedIndex, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        if (which >= 0) {
                            singleChoiceMaterialDialogListener.onItemSelected(items.get(which));
                            singleChoiceMaterialDialogListener.getPositionSelected(which);
                        }
                        return true;
                    }
                })
                .positiveText(android.R.string.ok)
                .positiveColorRes(color)
                .negativeText(android.R.string.cancel)
                .negativeColorRes(color)
                .onNegative(new MaterialDialog.SingleButtonCallback() {

                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        singleChoiceMaterialDialogListener.onCancelClick();
                    }
                })
                .widgetColorRes(color)
                .build();
        materialDialog.setCancelable(cancelable);
        materialDialog.show();
    }

    private int getSelectedItemIndex(List<String> items, String selectedItem) {
        if (selectedItem != null && selectedItem.length() > 0) {
            return items.indexOf(selectedItem);
        }
        return -1;
    }

    public void showConfirmationDialog(final Activity activity, String title, String content, int color) {
        materialDialog = new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .positiveText(activity.getString(android.R.string.yes))
                .positiveColorRes(color)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        activity.finish();
                    }
                })
                .negativeText(activity.getString(android.R.string.no))
                .negativeColorRes(color)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public void showProgressDialog(Activity activity, String title, String content, int color) {

        materialDialog = new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .progress(true, 0)
                .widgetColorRes(color)
                .show();
    }

    public void showSingleDialog(Activity activity, String title, String content, String dismissText, int color) {
        materialDialog = new MaterialDialog.Builder(activity)
                .title(title)
                .content(content)
                .negativeText(dismissText)
                .negativeColorRes(color)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public void dismissDialog() {
        materialDialog.dismiss();
    }
}

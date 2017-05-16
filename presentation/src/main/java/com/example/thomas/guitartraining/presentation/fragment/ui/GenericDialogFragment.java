package com.example.thomas.guitartraining.presentation.fragment.ui;

import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.view.GenericDialogFragmentView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Generic dialog fragment class.
 */
// TODO : Make a component instead of fragment ?
public class GenericDialogFragment extends DialogFragment implements GenericDialogFragmentView {

    @BindView(R.id.generic_dialog_content)
    TextView dialogFragmentContent;

    @BindView(R.id.generic_dialog_dismiss_button)
    Button dismissButton;

    private static final String DIALOG_FRAGMENT_TITLE = "com.example.thomas.guitartraining.presentation.fragment.ui.GenericDialogFragment.DIALOG_FRAGMENT_TITLE";
    private static final String DIALOG_FRAGMENT_CONTENT = "com.example.thomas.guitartraining.presentation.fragment.ui.GenericDialogFragment.DIALOG_FRAGMENT_CONTENT";
    private static final String DIALOG_FRAGMENT_DISMISS_BUTTON_TEXT = "com.example.thomas.guitartraining.presentation.fragment.ui.GenericDialogFragment.DIALOG_FRAGMENT_DISMISS_BUTTON_TEXT";

    private String dialogTitle;
    private String dialogContent;
    private String dialogDismissButtonText;

    public static GenericDialogFragment newInstance(String dialogTitle, String dialogContent, String dismissButtonText) {
        Bundle args = new Bundle();
        args.putString(DIALOG_FRAGMENT_TITLE, dialogTitle);
        args.putString(DIALOG_FRAGMENT_CONTENT, dialogContent);
        args.putString(DIALOG_FRAGMENT_DISMISS_BUTTON_TEXT, dismissButtonText);

        GenericDialogFragment genericDialogFragment = new GenericDialogFragment();
        genericDialogFragment.setArguments(args);

        return genericDialogFragment;
    }

    @SuppressWarnings("deprecation")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.generic_dialog_layout, container, false);

        ButterKnife.bind(this, rootView);
        Bundle args = getArguments();
        if (args != null) {
            dialogTitle = args.getString(DIALOG_FRAGMENT_TITLE);
            dialogContent = args.getString(DIALOG_FRAGMENT_CONTENT);
            dialogDismissButtonText = args.getString(DIALOG_FRAGMENT_DISMISS_BUTTON_TEXT);
        }

        getDialog().setCanceledOnTouchOutside(true);
        getDialog().setTitle(dialogTitle);
        dismissButton.setText(dialogDismissButtonText);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dialogFragmentContent.setText(Html.fromHtml(dialogContent, Html.FROM_HTML_MODE_COMPACT));
        } else {
            dialogFragmentContent.setText(Html.fromHtml(dialogContent));
        }

        return rootView;
    }

    @OnClick(R.id.generic_dialog_dismiss_button)
    public void handleClickGenericDialogDismissButton() {
        dismiss();
    }
}

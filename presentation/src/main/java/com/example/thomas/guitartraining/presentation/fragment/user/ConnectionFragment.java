package com.example.thomas.guitartraining.presentation.fragment.user;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.thomas.guitartraining.R;
import com.example.thomas.guitartraining.presentation.activity.LoginActivity;
import com.example.thomas.guitartraining.presentation.presenter.user.ConnectionPresenter;
import com.example.thomas.guitartraining.presentation.utils.KeyboardUtils;
import com.example.thomas.guitartraining.presentation.view.user.ConnectionView;
import com.example.thomas.guitartraining.presentation.activity.listener.LoginNavigatorListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConnectionFragment extends Fragment implements ConnectionView {

    @Inject
    ConnectionPresenter connectionPresenter;

    @BindView(R.id.fragment_connection_username_edit_text)
    EditText connectionUsernameEditText;
    @BindView(R.id.fragment_connection_password_edit_text)
    EditText connectionPasswordEditText;

    View rootView;

    public static ConnectionFragment newInstance() {

        Bundle args = new Bundle();

        ConnectionFragment fragment = new ConnectionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_connection, container, false);

        ButterKnife.bind(this, rootView);
        ((LoginActivity) getActivity()).getActivityComponent().inject(this);

        connectionPresenter.setConnectionView(this);
        connectionPresenter.setLoginNavigatorListener((LoginNavigatorListener) this.getActivity());

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.fragment_connection_validate_button)
    public void handleClickValidateLogin() {
        KeyboardUtils.hideKeyboard(getActivity());
        connectionPresenter.connectUser(this.getActivity(),
                String.valueOf(connectionUsernameEditText.getText()), String.valueOf(connectionPasswordEditText.getText()));
    }

}

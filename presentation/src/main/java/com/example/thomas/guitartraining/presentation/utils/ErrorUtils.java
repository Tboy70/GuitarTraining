package com.example.thomas.guitartraining.presentation.utils;

import android.content.Context;

import com.example.thomas.guitartraining.R;

import java.net.ConnectException;

import retrofit2.adapter.rxjava.HttpException;

public class ErrorUtils {

    private static final int HTTP_EXCEPTION_401 = 401;

    public static String translateException(Context context, Throwable throwable) {
        if (throwable instanceof HttpException) {
            HttpException exception = (HttpException) throwable;
            switch (exception.code()) {
                case HTTP_EXCEPTION_401:
                    if (exception.message().equals(context.getString(R.string.wrong_login_error_value_from_API))) {
                        return context.getString(R.string.snackbar_error_wrong_login);
                    }
                    break;
                default:
                    return context.getString(R.string.snackbar_error_unknown_error);
            }
        } else if (throwable instanceof ConnectException) {
            return context.getString(R.string.snackbar_error_connection_problem);
        } else {
            return context.getString(R.string.snackbar_error_unknown_error);
        }
        return context.getString(R.string.snackbar_error_unknown_error);
    }
}

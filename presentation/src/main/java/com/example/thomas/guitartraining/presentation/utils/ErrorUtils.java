package com.example.thomas.guitartraining.presentation.utils;

import android.content.Context;

import com.example.data.exception.LoginFailException;

public class ErrorUtils {
    public static String translateException(Context context, Throwable throwable) {
        if (throwable instanceof LoginFailException) {
            return "Erreur de login";
        } else {
            return "test";
        }
    }
}

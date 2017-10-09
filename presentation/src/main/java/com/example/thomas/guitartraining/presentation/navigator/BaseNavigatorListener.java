package com.example.thomas.guitartraining.presentation.navigator;

import android.view.View;

public interface BaseNavigatorListener {
    void requestRenderError(Throwable e, int mode, View viewId);
    void requestRenderErrorString(String error, int mode, View viewId);
}

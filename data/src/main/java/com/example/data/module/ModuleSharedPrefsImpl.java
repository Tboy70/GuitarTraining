package com.example.data.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ModuleSharedPrefsImpl implements ModuleSharedPrefs {

    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

    private SharedPreferences sharedPreferences;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ModuleSharedPrefsImpl(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public void setIdUserInSharedPrefs(int idUser) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(CURRENT_USER_ID, idUser);
        editor.apply();
    }
}

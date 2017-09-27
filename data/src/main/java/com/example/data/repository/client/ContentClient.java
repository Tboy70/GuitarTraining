package com.example.data.repository.client;

import com.example.data.module.ModuleSharedPrefs;
import com.example.data.module.ModuleSharedPrefsImpl;

import javax.inject.Inject;

import rx.Observable;

public class ContentClient {

    private ModuleSharedPrefs moduleSharedPrefs;

    @SuppressWarnings("WeakerAccess")
    @Inject
    public ContentClient(ModuleSharedPrefsImpl moduleSharedPrefs) {
        this.moduleSharedPrefs = moduleSharedPrefs;
    }

    public Observable<Boolean> setIdUserInSharedPrefs(String idUser) {
        try {
            moduleSharedPrefs.setIdUserInSharedPrefs(idUser);
            return Observable.just(true);
        } catch (Exception e) {
            return Observable.error(e);
        }
    }
}

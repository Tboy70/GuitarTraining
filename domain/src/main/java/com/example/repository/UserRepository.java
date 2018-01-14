package com.example.repository;

import com.example.model.User;

import rx.Observable;

/**
 * Interface implemented by the UserDataRepository class.
 */
public interface UserRepository {

    Observable<Boolean> setIdUserInSharedPrefs(String idUser);

    Observable<User> connectUser(User user);

    Observable<String> getIdInSharedPrefs();
}

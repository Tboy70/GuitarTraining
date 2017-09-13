package com.example.repository;

import com.example.model.User;

import rx.Observable;

/**
 * Interface implemented by the UserDataRepository class.
 */
public interface UserRepository {

    Observable<Boolean> setIdUserInSharedPrefs(int idUser);

    Observable<User> connectUser(String username, String password);
}

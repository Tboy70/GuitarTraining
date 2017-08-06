package com.example.repository;

import com.example.model.User;

import java.util.List;

import rx.Observable;

/**
 * Interface implemented by the UserDataRepository class.
 */
public interface UserRepository {

    /**
     * Get all the users of the application.
     *
     * @return Observable -> List of User models.
     */
    Observable<List<User>> getAllUsers();

    Observable<User> connectUser(String username, String password);
}

package com.ovent.domain.repositories;

import com.ovent.domain.User;

import rx.Observable;

/**
 * Created by Kunal on 18/12/15.
 */

public interface UserRepository {
    Observable<User> loginByEmail(final User user);
    Observable<User> signup(final String name,final String phone,final String password);
}

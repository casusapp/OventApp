package com.ovent.domain.interactors;

import com.ovent.domain.User;
import com.ovent.domain.executors.PostExecutionThread;
import com.ovent.domain.executors.ThreadExecutor;
import com.ovent.domain.repositories.UserRepository;

import rx.Observable;

/**
 * Created by Kunal on 18/12/15.
 */
public final class LoginUserByEmail extends UseCase<User> {

    private UserRepository mUserRepository;
    private User mUser;

    public LoginUserByEmail(final User user, final UserRepository userRepository,
                            final ThreadExecutor threadExecutor, final PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mUser = user;
        mUserRepository = userRepository;
    }

    @Override
    public Observable<User> buildUseCaseObservable() {
        return mUserRepository.loginByEmail(mUser);
    }
}
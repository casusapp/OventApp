package com.ovent.domain.interactors;

import com.ovent.domain.User;
import com.ovent.domain.executors.PostExecutionThread;
import com.ovent.domain.executors.ThreadExecutor;
import com.ovent.domain.repositories.UserRepository;

import rx.Observable;

/**
 * Author : Kunal Chavhan
 * Date : 22/12/15.
 * Email : kunal.chavhan005@gmail.com
 */
public final class SignUp extends UseCase<User> {

    private UserRepository mUserRepository;
    private String mName;
    private String mPhone;
    private String mPassword;

    public SignUp(final String name,final String phone, final String password,final UserRepository userRepository, final ThreadExecutor threadExecutor,final PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mUserRepository = userRepository;
        mName = name;
        mPassword = password;
        mPhone = phone;
    }

    @Override
    public Observable<User> buildUseCaseObservable() {
        return mUserRepository.signup(mName,mPhone,mPassword);
    }
}

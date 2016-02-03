package com.ovent.presenters;

import com.ovent.domain.User;
import com.ovent.domain.interactors.LoginUserByEmail;
import com.ovent.domain.repositories.UserRepository;

import rx.Subscriber;

/**
 * Created by Kunal on 18/12/15.
 */
public final class LoginPresenter extends Presenter {

    private UserRepository mUserRepository;

    public LoginPresenter() {
        mUserRepository = new com.ovent.data.repositories.UserRepository();
    }

    public void loginUserByEmail(final User user, final Subscriber<User> userSubscriber) {
        mSubscriptions.add(new LoginUserByEmail(user, mUserRepository,
                mThreadExecutor, mPostExecutionThread).execute(userSubscriber));
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        cancelRunningUseCases();
    }
}
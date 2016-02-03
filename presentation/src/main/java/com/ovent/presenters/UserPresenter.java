package com.ovent.presenters;

import com.ovent.domain.User;
import com.ovent.domain.executors.ThreadExecutor;
import com.ovent.domain.interactors.SignUp;
import com.ovent.domain.repositories.UserRepository;

import rx.Subscriber;

/**
 * Author : Kunal Chavhan
 * Date : 22/12/15.
 * Email : kunal.chavhan005@gmail.com
 */
public final class UserPresenter extends Presenter{

    private UserRepository mUserRepository;
    public UserPresenter(){
        mUserRepository = new com.ovent.data.repositories.UserRepository();
    }

    public void signUp(final String name,final String phone,final String password,final Subscriber<User> subscriber){
        mSubscriptions.add(new SignUp(name,phone,password,mUserRepository,mThreadExecutor,mPostExecutionThread).execute(subscriber));
    }
    @Override
   public void resume() {
        cancelRunningUseCases();
    }

    @Override
   public void pause() {
        cancelRunningUseCases();
    }

    @Override
    public void destroy() {
        cancelRunningUseCases();
    }
}

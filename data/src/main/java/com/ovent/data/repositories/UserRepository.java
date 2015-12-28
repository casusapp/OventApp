package com.ovent.data.repositories;

import com.ovent.data.entites.UserEntity;
import com.ovent.data.mappers.UserMapper;
import com.ovent.data.net.UserApis;
import com.ovent.data.retrofit.RetrofitFactory;
import com.ovent.domain.User;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Kunal on 18/12/15.
 */
public final class UserRepository implements com.ovent.domain.repositories.UserRepository {
    private static final String TAG = "##UserRepository##";
    private UserApis mUserApis;

    public UserRepository() {
        mUserApis = RetrofitFactory.getInstance().create(UserApis.class);
    }

    @Override
    public Observable<User> loginByEmail(final User user) {
        final UserEntity userEntity = UserMapper.transform(user);
        return mUserApis.loginUserByEmail(userEntity).map(new Func1<UserEntity, User>() {
            @Override
            public User call(UserEntity userEntity) {
           //     userEntity.setIsFacebook(false);
            //    userEntity.setIsGplus(false);
            //    userEntity.setIsLoggedIn(true);
                return UserMapper.transform(userEntity);
            }
        });
    }

    @Override
    public Observable<User> signup(final String name,final String phone,final String password) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setPassword(password);
        userEntity.setPhoneNumber(phone);
        return mUserApis.signup(userEntity).map(new Func1<UserEntity, User>() {
            @Override
            public User call(UserEntity userEntity) {
                return UserMapper.transform(userEntity);
            }
        });
    }
}

 /*   @Override
    public Observable<Void> saveUserLocally(final User user) {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                UserHelper.SaveUserLocally(user);
                subscriber.onNext(null);
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public Observable<User> getAuthorizedLocalUser() {
        return Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {
                final Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                *//**
 * For now we are returning just the first and only saved user
 *//*
                final UserEntity userEntity = realm.where(UserEntity.class).findFirst();
                if(userEntity == null){
                    realm.commitTransaction();
                    subscriber.onNext(null);
                    subscriber.onCompleted();
                    return;
                }
                final User user = UserMapper.transform(userEntity);
                realm.commitTransaction();
                subscriber.onNext(user);
                subscriber.onCompleted();
            }
        });
    }
}*/